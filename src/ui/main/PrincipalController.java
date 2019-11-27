package ui.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PrincipalController implements Initializable {
    
    private Label label;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("OK");
        label.setText("OK");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void abrirCadastroCliente(ActionEvent event)throws IOException{
        //Código para abrir uma nova Janela
        //Ler o FXML que representa a nova janela
        //(adicionar o throws)
        Parent root = FXMLLoader.load(getClass()
                .getResource("/ui/cliente/JanelaCliente.fxml"));
        //Criando a cena
        Scene scene = new Scene(root);
        //Criando a janela (STAGE) 
        Stage stage = new Stage(StageStyle.UTILITY);
        //Titulo na janela
        stage.setTitle("Cadastro de Cliente");
        //Adicionando a cena na janela
        stage.setScene(scene);
        
        //Configurando o MODALITY
        //Diz respeito ao comportamento das janelas anteriores
        //quando essa for mostrada
        //Para bloquear interação com as janelas anteriores
        stage.initModality(Modality.APPLICATION_MODAL);
        
        //Mostrando a nova janela
        stage.show();
    }

    @FXML
    private void abrirCadastroCachorro(ActionEvent event)throws IOException{
        //Código para abrir uma nova Janela
        //Ler o FXML que representa a nova janela
        //(adicionar o throws)
        Parent root = FXMLLoader.load(getClass()
                .getResource("/ui/cachorro/JanelaCachorro.fxml"));
        //Criando a cena
        Scene scene = new Scene(root);
        //Criando a janela (STAGE) 
        Stage stage = new Stage(StageStyle.UTILITY);
        //Titulo na janela
        stage.setTitle("Cadastro de Cachorro");
        //Adicionando a cena na janela
        stage.setScene(scene);
        
        //Configurando o MODALITY
        //Diz respeito ao comportamento das janelas anteriores
        //quando essa for mostrada
        //Para bloquear interação com as janelas anteriores
        stage.initModality(Modality.APPLICATION_MODAL);
        
        //Mostrando a nova janela
        stage.show();
    }

    @FXML
    private void abrirAdocao(ActionEvent event) {
    }

    @FXML
    private void AbrirFichamedica(ActionEvent event) {
    }
    
    
}
