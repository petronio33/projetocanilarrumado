/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cachorro;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dados.entidades.Cachorro;
import dados.entidades.Cliente;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import servicos.CachorroServico;
import servicos.ClienteServico;

/**
 * FXML Controller class
 *
 * @author Petrônio
 */
public class JanelaCachorroController implements Initializable {

    @FXML
    private JFXTextField textFieldId;
    @FXML
    private JFXTextField textFieldNome;
    @FXML
    private JFXTextField textFieldRaca;
    @FXML
    private JFXTextField textFieldObservacao;
    @FXML
    private TableView<Cachorro> tabela;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colNome;
    @FXML
    private TableColumn colDono;
    @FXML
    private TableColumn colRaca;
    @FXML
    private TableColumn colPorte;
    @FXML
    private TableColumn colSexo;
    @FXML
    private TableColumn colObservacao;
    @FXML
    private JFXComboBox<Cliente> comboBoxDono;
    @FXML
    private JFXComboBox comboBoxSexo;
    @FXML
    private JFXComboBox comboBoxPorte;

    private CachorroServico servico = new CachorroServico();

    private ObservableList<Cachorro> dados
            = FXCollections.observableArrayList();
    
    private ObservableList<String> sexo
            = FXCollections.observableArrayList
        ("Feminino","Masculino");
   
    private ObservableList<String> porte
            = FXCollections.observableArrayList
        ("Pequeno","Médio","Grande");
    
     private ClienteServico clienteServico = new ClienteServico();

    private Cachorro selecionado;
    @FXML
    private JFXButton botaopesquisar;
    @FXML
    private JFXTextField pesquisanome;

    /**
     * Initializes the controller class.
     *
     */
    public void mensagemDeErro(String MDE) {
        Alert cuidado = new Alert(Alert.AlertType.ERROR);
        cuidado.setTitle("Erro!");
        cuidado.setHeaderText(null);
        cuidado.setContentText(MDE);
        cuidado.showAndWait();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configurarTabela();
        listarCachorroTabela();
        comboBoxPorte.setItems(porte);
        comboBoxSexo.setItems(sexo);
        listarCliente();
    }

    @FXML
    private void salvar(ActionEvent event) {

        if (textFieldId.getText().isEmpty()) {
            Cachorro c = new Cachorro(textFieldRaca.getText(),
                    textFieldNome.getText(),
                    comboBoxPorte.getValue().toString(),
                    comboBoxSexo.getValue().toString(),
                    textFieldObservacao.getText(),
                    comboBoxDono.getValue());
                    

            servico.salvar(c);

            mensagemsucesso("Cachorro salvo com sucesso");

            listarCachorroTabela();

        } else {

            Optional<ButtonType> btn
                    = mensagemDeConfirmacao("Deseja efetuar as alterações?",
                            "Editar");
            if (btn.get() == ButtonType.OK) {
                
                selecionado.setNome(textFieldNome.getText());
                selecionado.setRaca(textFieldRaca.getText());
                selecionado.setObservacao(textFieldObservacao.getText());
                selecionado.setPorte(comboBoxPorte.getValue().toString());
                selecionado.setSexo(comboBoxSexo.getValue().toString());
                selecionado.setDono(comboBoxDono.getValue());

                servico.editar(selecionado);

                mensagemsucesso("Cachorro Atualizado!");
                listarCachorroTabela();

            }
        }
        textFieldNome.setText(" ");
        textFieldRaca.setText(" ");
        textFieldObservacao.setText(" ");
    }

    @FXML
    private void editar(ActionEvent event) {
        selecionado = tabela.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            textFieldId.setText(
                    String.valueOf(selecionado.getIdCachorro()));
            textFieldNome.setText(selecionado.getNome());
            textFieldRaca.setText(selecionado.getRaca());
            textFieldObservacao.setText(selecionado.getObservacao());
            comboBoxPorte.setValue(selecionado.getPorte().toString());
            comboBoxSexo.setValue(selecionado.getSexo().toString());
            comboBoxDono.setValue(selecionado.getDono());
            
            
            
            ///listarCachorroTabela();
        } else {
            mensagemDeErro("Selecione um Cachorro!");

        }

    }

    @FXML
    private void excluir(ActionEvent event) {
        selecionado = tabela.getSelectionModel().getSelectedItem();

        if (selecionado != null) {

            Optional<ButtonType> btn = mensagemDeConfirmacao("Deseja excluir o cachorro?",
                    "Excluido");
            if (btn.get() == ButtonType.OK) {
                servico.excluir(selecionado);

                mensagemsucesso("Cachorro apagado!");

                listarCachorroTabela();

            }
            listarCachorroTabela();
        }

    }

    public void mensagemsucesso(String mes) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Sucesso!");
        alerta.setHeaderText(null);
        alerta.setContentText(mes);
        alerta.showAndWait();

    }

    private void configurarTabela() {
        colId.setCellValueFactory(
                new PropertyValueFactory("idCachorro"));
        colNome.setCellValueFactory(
                new PropertyValueFactory("nome"));
        colRaca.setCellValueFactory(
                new PropertyValueFactory("raca"));
        colObservacao.setCellValueFactory(
                new PropertyValueFactory("observacao"));
        colPorte.setCellValueFactory(
                new PropertyValueFactory("porte"));
        colSexo.setCellValueFactory(
                new PropertyValueFactory("sexo"));
        colDono.setCellValueFactory(
                new PropertyValueFactory("dono"));
    }

    private void listarCachorroTabela() {

        dados.clear();

        List<Cachorro> cachorros = servico.listar();
        dados = FXCollections.observableArrayList(cachorros);

        tabela.setItems(dados);
    }

    private Optional<ButtonType> mensagemDeConfirmacao(String mensagem, String titulo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        return alert.showAndWait();
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        dados.clear();
        String nome = pesquisanome.getText();

        List<Cachorro> cachorros = servico.buscarPeloNome(nome);
        dados = FXCollections.observableArrayList(cachorros);

        tabela.setItems(dados);
    }
   private void listarCliente(){
       List<Cliente> clientes = clienteServico.listar();
       
       
       comboBoxDono.setItems(FXCollections.observableArrayList(clientes));
   }
}
