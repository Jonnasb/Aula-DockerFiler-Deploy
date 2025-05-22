import React, { useState } from 'react';
import api from '../../services/api';

export default function Cadastro() {
  const [nome, setNome] = useState('');
  const [idade, setIdade] = useState('');

  async function handleSubmit(e) {
    e.preventDefault();
    try {
      await api.post('/jogadores', { nome, idade });
      alert('Jogador cadastrado!');
    } catch (err) {
      alert('Erro no cadastro');
    }
  }

  return (
    <form onSubmit={handleSubmit}>
      <input placeholder="Nome" value={nome} onChange={e => setNome(e.target.value)} />
      <input placeholder="Idade" value={idade} onChange={e => setIdade(e.target.value)} />
      <button type="submit">Cadastrar</button>
    </form>
  );
}
