package br.edu.ifnmg.aplicacao_exemplo_spring.apresentacao_javafx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.LogNivel;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.AutenticacaoServico;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.LogServico;
import net.rgielen.fxweaver.core.FxmlView;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Service
@FxmlView("viewLogin.fxml")
public class LoginController {

    @Autowired
    private AutenticacaoServico autenticacao;

    @Autowired
    private LogServico logs;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField pwdSenha;

    public LoginController() {

    }


    @FXML
    public void autenticar(Event e){
        if(autenticacao.autenticar(txtLogin.getText(), pwdSenha.getText())){
            logs.registrar(LogNivel.Informacao, "Login", txtLogin.getText());
        } else {
            logs.registrar(LogNivel.Erro, "Login", txtLogin.getText());
        }
    }
    
    
}
