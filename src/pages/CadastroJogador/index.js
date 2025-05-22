import { useState } from "react";
import api from "../../services/api";
import { useNavigate } from "react-router-dom";
import useMensagem from "../../hooks/useMensagem";
import MensagemFeedback from "../../components/MensagemFeedback";
import "./styles.css";

function CadastroJogador() {
  const [jogador, setJogador] = useState({
    nome: "",
    sexo: "",
    idade: "",
    altura: "",
    peso: "",
    posicao: "",
    numeroCamisa: "",
  });

  const navigate = useNavigate();
  const { exibirMensagem, mensagem, tipoMensagem, visivel, fecharMensagem } = useMensagem();

  const handleChange = (e) => {
    setJogador({ ...jogador, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post("/jogadores", jogador);
      exibirMensagem("Jogador cadastrado com sucesso!", "sucesso");
      setJogador({ nome: "", sexo: "", idade: "", altura: "", peso: "", posicao: "", numeroCamisa: "" });
      navigate("/jogadores");
    } catch (error) {
      exibirMensagem("Erro ao cadastrar jogador.", "erro");
    }
  };

  return (
    <div className="pagina-cadastro">
      <h2>Cadastro de Jogador</h2>
      <form onSubmit={handleSubmit}>
        {Object.entries(jogador).map(([campo, valor]) => (
          <input
            key={campo}
            name={campo}
            value={valor}
            onChange={handleChange}
            placeholder={campo.charAt(0).toUpperCase() + campo.slice(1)}
            required
          />
        ))}
        <button type="submit">Cadastrar</button>
      </form>

      <MensagemFeedback
        mensagem={mensagem}
        tipo={tipoMensagem}
        visivel={visivel}
        onclose={fecharMensagem}
      />
    </div>
  );
}

export default CadastroJogador;
