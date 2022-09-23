package br.edu.ifnmg.aplicacao_exemplo_spring.apresentacao_javafx;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifnmg.aplicacao_exemplo_spring.entidades.Usuario;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.LogServico;
import br.edu.ifnmg.aplicacao_exemplo_spring.servicos.UsuarioRepositorio;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

    public void configurarTabela() {

        tblBusca.getColumns().removeAll(tblBusca.getColumns());

        TableColumn<Usuario, String> login = 
            new TableColumn<>("Login");
        
        login.setCellValueFactory(
            new PropertyValueFactory<>("login"));

        tblBusca.getColumns().add(login);

        TableColumn<Usuario, Date> data_criacao = 
            new TableColumn<>("Data Criacao");
        
        data_criacao.setCellValueFactory(
            new PropertyValueFactory<>("dataCriacao"));

        tblBusca.getColumns().add(data_criacao);
    }

    @FXML
    public void initialize(){
        configurarTabela();
    }

    @FXML
    public void buscar(Event e){
        Usuario filtro = new Usuario();
        filtro.setLogin(txtLoginBusca.getText());
        List<Usuario> resultado = repositorio.Buscar(filtro);
        
        for(Usuario u : resultado){
            tblBusca.getItems().add(u);
        }
    }
    
}
