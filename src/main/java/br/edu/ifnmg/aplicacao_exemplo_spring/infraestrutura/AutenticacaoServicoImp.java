package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.AutenticacaoServico;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.UsuarioRepositorio;

@Service
@Scope("singleton")
public class AutenticacaoServicoImp implements AutenticacaoServico {
    private Usuario usuario;

    @Autowired
    private UsuarioRepositorio repositorio;

    public AutenticacaoServicoImp() {
        this.usuario = null;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        usuario = repositorio.Abrir(login);
        if(usuario != null){
            if(usuario.getSenha().equals(senha)){
                return true;
            } else {
                usuario = null;
            }
        }
        return false;
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }
}
