package br.edu.ifnmg.aplicacao_exemplo_spring.apresentacao_javafx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.LogNivel;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.AutenticacaoServico;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.LogServico;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;

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
            Alert alert = new Alert(AlertType.INFORMATION, "Bem vindo ao sistema! ", ButtonType.OK);
            alert.showAndWait();
        } else {
            logs.registrar(LogNivel.Erro, "Login", txtLogin.getText());
            Alert alert = new Alert(AlertType.CONFIRMATION, "Erro ao acessar o sistema. Deseja sair?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                
            }
        }
    }
    
    
}
