package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.Repositorio;


public class DAO<T> implements Repositorio<T> {

    @PersistenceContext
    private EntityManager manager;
    private Class<T> classe;

    public DAO(Class<T> classe){
		this.classe = classe;
    }


    public EntityManager getManager() {
        return manager;
    }

    public Class<T> getClasse() {
        return classe;
    }

    @Override
    public T Abrir(Long id) {
        try {
            return (T) manager.find(this.classe, id);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public boolean Salvar(T obj) {
        try {
            obj = manager.merge(obj);
            manager.flush();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean Apagar(T obj) {
        try {
            manager.remove(obj);
            manager.flush();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional
    public List<T> Buscar(T filtro) {
        try {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<T> cr = cb.createQuery(classe);
        Root<T> root = cr.from(classe);
        cr.select(root);

        Query consulta = manager.createQuery(cr);

        return consulta.getResultList();
        } catch(Exception ex){
            return null;
        }
    }



    
}
