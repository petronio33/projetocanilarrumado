/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.cachorro;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dados.entidades.Cachorro;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private JFXComboBox<?> comboBoxDono;
    @FXML
    private JFXComboBox<?> comboBoxSexo;
    @FXML
    private JFXComboBox<?> comboBoxPorte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvar(ActionEvent event) {
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
    }
    
}
