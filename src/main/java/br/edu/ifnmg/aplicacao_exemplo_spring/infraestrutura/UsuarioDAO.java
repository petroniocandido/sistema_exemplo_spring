package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

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
    @Transactional
    public Usuario Abrir(String login) {
        try {
            Query consulta = getManager().createQuery("select u from Usuario u where u.login = ?");
            consulta.setParameter(1, login);
    
            return (Usuario) consulta.getSingleResult();
            } catch(Exception ex){
                return null;
            }
    }
    
}
