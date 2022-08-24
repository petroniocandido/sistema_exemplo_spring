package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Pessoa;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.AutenticacaoServico;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.LogServico;

public class PessoaDAO<T extends Pessoa> extends DAO<T> {

    @Autowired
    protected AutenticacaoServico autenticacao;

    @Autowired
    protected LogServico log;

    public PessoaDAO(Class<T> classe) {
        super(classe);
    }

    @Override
    @Transactional
    public boolean Salvar(T obj) {
        if(obj.getId() == 0){
            obj.setDataCriacao(new Date());
            obj.setCriador(autenticacao.getUsuario());
        }
        obj.setDataUltimaModificacao(new Date());
        obj.setUltimoModificador(autenticacao.getUsuario());

        return super.Salvar(obj);
    }
    
}
