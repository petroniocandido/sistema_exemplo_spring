package br.edu.ifnmg.aplicacao_exemplo_spring.infraestrutura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Log;
import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.LogNivel;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.AutenticacaoServico;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.LogRepositorio;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.LogServico;

@Service
@Scope("singleton")
public class LogServicoImp implements LogServico {

    @Autowired
    private AutenticacaoServico autenticacao;

    @Autowired
    private LogRepositorio repositorio;

    @Override
    public void registrar(LogNivel nivel, String acao, String descricao) {
        
        Log l = new Log(nivel, autenticacao.getUsuario(), acao, descricao);

        repositorio.Salvar(l);
        
    }

    @Override
    public void registrar(LogNivel nivel, String acao) {
        registrar(nivel, acao, "");        
    }
    
}
