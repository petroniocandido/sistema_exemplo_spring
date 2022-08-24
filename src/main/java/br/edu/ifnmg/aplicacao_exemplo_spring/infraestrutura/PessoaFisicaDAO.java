package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.PessoaFisica;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.PessoaFisicaRepositorio;

@Service
public class PessoaFisicaDAO 
    extends DAO<PessoaFisica>
    implements PessoaFisicaRepositorio {

    public PessoaFisicaDAO() {
        super(PessoaFisica.class);
    }

    @Override
    @Transactional
    public boolean Salvar(PessoaFisica obj) {
        if(obj.getId() == 0){
            obj.setDataCriacao(new Date());
        }
        obj.setDataUltimaModificacao(new Date());

        return super.Salvar(obj);
    }
    
}
