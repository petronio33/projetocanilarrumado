/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.FichaMedica;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
 * @author rafae
 */
public class FichaMedicaController implements Initializable {

    @FXML
    private JFXComboBox<?> comboBoxCachorro;
    @FXML
    private JFXTextArea textFieldObservacao;
    @FXML
    private JFXTextField textFieldSexo;
    @FXML
    private JFXTextField textFieldPorte;
    @FXML
    private JFXTextField textFieldRaca;
    @FXML
    private JFXTextArea textAreaAtendimentos;
    @FXML
    private JFXTextField textFieldVeterinario;
    @FXML
    private JFXDatePicker datePickerAtendimento;
    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn colCachorro;
    @FXML
    private TableColumn colVeterinario;
    @FXML
    private TableColumn colDataAtendimento;
    @FXML
    private TableColumn colAtendimentos;
    @FXML
    private JFXTextField pesquisaNome;

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

    @FXML
    private void pesquisar(ActionEvent event) {
    }
    
}
