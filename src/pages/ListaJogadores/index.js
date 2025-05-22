import { useEffect, useState } from "react";
import api from "../../services/api";
import "./styles.css";

function ListaJogadores() {
  const [jogadores, setJogadores] = useState([]);

  useEffect(() => {
    const buscarJogadores = async () => {
      try {
        const response = await api.get("/jogadores");
        setJogadores(response.data);
      } catch (error) {
        alert("Erro ao carregar jogadores.");
      }
    };
    buscarJogadores();
  }, []);

  return (
    <div className="lista-jogadores">
      <h2>Lista de Jogadores</h2>
      <ul>
        {jogadores.length === 0 ? (
          <li>Nenhum jogador encontrado.</li>
        ) : (
          jogadores.map((j) => (
            <li key={j.id}>
              <strong>Nome:</strong> {j.nome} <br />
              <strong>Posição:</strong> {j.posicao} <br />
              <strong>Camisa:</strong> {j.numeroCamisa}
            </li>
          ))
        )}
      </ul>
    </div>
  );
}

export default ListaJogadores;
