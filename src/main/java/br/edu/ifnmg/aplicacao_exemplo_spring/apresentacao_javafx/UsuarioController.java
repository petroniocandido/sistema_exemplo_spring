package br.edu.ifnmg.aplicacao_exemplo_spring.apresentacao_javafx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.LogServico;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.UsuarioRepositorio;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("viewUsuarios.fxml")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio repositorio;

    @Autowired
    private LogServico logs;

    @FXML
    private TextField txtLoginBusca;

    @FXML
    private TableView tblBusca;

    public UsuarioController() {
    }

    @FXML
    public void buscar(Event e){
        
    }
    
}
