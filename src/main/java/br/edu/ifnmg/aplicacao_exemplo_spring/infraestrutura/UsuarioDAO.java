package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import javax.persistence.Query;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.UsuarioRepositorio;

@Service
public class UsuarioDAO 
    extends DAO<Usuario>
    implements UsuarioRepositorio {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public Usuario Abrir(String login) {
        try {
            Query consulta = getManager()
            .createQuery("select u from Usuario u where u.login = :login");
            consulta.setParameter("login", login);
    
            return (Usuario) consulta.getSingleResult();
            } catch(Exception ex){
                System.out.println(ex.getMessage());
                return null;
            }
    }
    
}
