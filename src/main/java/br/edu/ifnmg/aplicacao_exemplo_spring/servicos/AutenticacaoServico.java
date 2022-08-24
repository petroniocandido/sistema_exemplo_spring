package br.edu.ifnmg.aplicacao_exemplo_spring.servicos;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Usuario;

public interface AutenticacaoServico {
    public boolean autenticar(String usuario, String senha);
    public Usuario getUsuario();
}
