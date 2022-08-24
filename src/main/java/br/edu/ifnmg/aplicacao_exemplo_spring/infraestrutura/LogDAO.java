package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Log;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.LogRepositorio;

@Service
public class LogDAO extends DAO<Log> implements LogRepositorio {

    public LogDAO() {
        super(Log.class);
    }
    
}
