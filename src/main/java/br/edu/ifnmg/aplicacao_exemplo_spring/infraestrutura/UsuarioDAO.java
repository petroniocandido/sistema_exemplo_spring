package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

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

    @Override
    @Transactional
    public List<Usuario> Buscar(Usuario filtro) {
        try {
            String jpql = "select u from Usuario u";
            
            if(!filtro.getLogin().isEmpty()){
                jpql += " where u.login like :login";
            }
            Query consulta = getManager().createQuery(jpql);
            if(!filtro.getLogin().isEmpty()){
                consulta.setParameter("login", filtro.getLogin());
            }
            return consulta.getResultList();
        } catch(Exception ex){
            return null;
        }
    }
    
}
