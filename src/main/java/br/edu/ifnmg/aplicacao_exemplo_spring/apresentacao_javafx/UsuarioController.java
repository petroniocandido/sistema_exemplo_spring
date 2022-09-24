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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import net.rgielen.fxweaver.core.FxmlView;

@Service
@FxmlView("viewUsuarios.fxml")
public class UsuarioController extends Controller {

    private Usuario entidade;

    @Autowired
    private UsuarioRepositorio repositorio;

    @Autowired
    private LogServico logs;

    @FXML
    private TextField txtLoginBusca;

    @FXML
    private TableView tblBusca;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField pwdSenha;

    @FXML 
    private Label lblUltimaModificacao;

    @FXML 
    private Label lblDataCadastro;

    @FXML
    private TabPane abas;


    public UsuarioController() {
    }

    @FXML
    @Override
    public void initialize() {
        super.initialize();
        configurarTabela();
        abas.getTabs().get(1).setDisable(true);
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

        TableViewSelectionModel<Usuario> selectionModel = tblBusca.getSelectionModel();

        selectionModel.setSelectionMode(SelectionMode.SINGLE);

        tblBusca.setSelectionModel(selectionModel);
    }


    public Usuario getEntidade() {
        return entidade;
    }

    public void setEntidade(Usuario entidade) {
        this.entidade = entidade;
    }

    public void carregarCampos() {
        txtLogin.setText(entidade.getLogin());
        pwdSenha.setText(entidade.getSenha());
        lblDataCadastro.setText(entidade.getDataCriacao().toString());
        lblUltimaModificacao.setText(entidade.getDataUltimaModificacao().toString());
    }

    public void carregarEntidade() {
        entidade.setLogin(txtLogin.getText());
        entidade.setSenha(pwdSenha.getText());
    }

    @FXML
    public void buscar(Event e){
        Usuario filtro = new Usuario();
        filtro.setLogin(txtLoginBusca.getText());
        List<Usuario> resultado = repositorio.Buscar(filtro);

        tblBusca.getItems().removeAll(tblBusca.getItems());
        
        for(Usuario u : resultado){
            tblBusca.getItems().add(u);
        }
    }

    @FXML
    public void editar(Event e){
        setEntidade((Usuario)tblBusca.getSelectionModel().getSelectedItem());
        carregarCampos();
        abas.getTabs().get(1).setDisable(false);
        abas.getSelectionModel().select(1);
    }

    @FXML
    public void novo(Event e){
        setEntidade(new Usuario());
        carregarCampos();
        abas.getTabs().get(1).setDisable(false);
        abas.getSelectionModel().select(1);
    }

    @FXML
    public void salvar(Event e){
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente salvar as alterações?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {
            carregarEntidade();
            if(repositorio.Salvar(entidade)){
                Alert confirmacao = new Alert(AlertType.INFORMATION, "Registro salvo com sucesso! ", ButtonType.OK);
                confirmacao.showAndWait();
            } else {
                Alert confirmacao = new Alert(AlertType.ERROR, "Falha ao salvar o registro! Contacte o administrador do sistema.", ButtonType.OK);
                confirmacao.showAndWait();
            }
        } else {
            Alert confirmacao = new Alert(AlertType.INFORMATION, "Operação cancelada! ", ButtonType.OK);
            confirmacao.showAndWait();
        }
    }
    
}
