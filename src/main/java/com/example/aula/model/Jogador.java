package com.example.aula.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "tab_jogadores")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotBlank(message = "Campo obrigatório.")
    private String nome;

    @NotBlank(message = "Campo obrigatório.")
    private String idade;

    @NotBlank(message = "Campo obrigatório.")
    private String altura;


    @NotBlank(message = "Campo obrigatório.")
    private String peso;

    @NotBlank(message = "Campo obrigatório.")
    private String posicao;

    @NotBlank(message = "Campo obrigatório.")
    private String numeroCamisa;

    public Jogador() {

    }


    public Jogador(Long id, Sexo sexo, String nome, String idade, String altura, String peso, String posicao, String numeroCamisa) {
        this.id = id;
        this.sexo = sexo;
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.posicao = posicao;
        this.numeroCamisa = numeroCamisa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(String numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }
}
