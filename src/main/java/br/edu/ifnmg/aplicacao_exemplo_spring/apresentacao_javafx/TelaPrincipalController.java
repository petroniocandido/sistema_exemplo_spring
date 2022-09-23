package br.edu.ifnmg.aplicacao_exemplo_spring.apresentacao_javafx;

import org.springframework.stereotype.Service;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("telaPrincipal.fxml")
public class TelaPrincipalController extends Controller {

    @FXML
    AnchorPane painelPrincipal;

    public TelaPrincipalController() {

    }

    public void carregarPanel(Class controller){
        FxWeaver fxWeaver = getContextoSpring().getBean(FxWeaver.class);
        Parent painel = (Parent) fxWeaver.loadView(controller);
        
        painelPrincipal.getChildren().removeAll(painelPrincipal.getChildren());
        painelPrincipal.getChildren().add(painel);
    }

    public void telaUsuarios(Event e){
        carregarPanel(UsuarioController.class);
    }
    
}
