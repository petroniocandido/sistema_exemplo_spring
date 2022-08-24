package br.edu.ifnmg.aplicacao_exemplo_spring.servicos;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.LogNivel;

public interface LogServico {
    public void registrar(LogNivel nivel, String acao, String descricao);
    public void registrar(LogNivel nivel, String descricao);
}
