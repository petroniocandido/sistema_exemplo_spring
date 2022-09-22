package br.edu.ifnmg.aplicacao_exemplo_spring.apresentacao_javafx;

import org.springframework.stereotype.Service;

import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("telaPrincipal.fxml")
public class TelaPrincipalController extends Controller {

    public TelaPrincipalController() {
    }
    
}
