package br.edu.ifnmg.aplicacao_exemplo_spring.apresentacao_javafx;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;

@FxmlView("template.jxml")
@Component
public class MenuController extends Controller {

    @FXML
    VBox principal;

    public MenuController() {
    }

    @FXML
    public void telaUsuarios(Event e){
        carregarScene(principal, UsuarioController.class);
    }
}
