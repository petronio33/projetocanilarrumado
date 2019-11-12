package ui.cliente;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dados.entidades.Cliente;
import java.net.URL;
import java.time.LocalDate;
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
import servicos.ClienteServico;

/**
 * FXML Controller class
 *
 * @author Petrônio
 */
public class JanelaClienteController implements Initializable {

    @FXML
    private JFXTextField textFieldId;
    @FXML
    private JFXTextField textFieldNome;
    @FXML
    private JFXTextField textFieldCPF;
    @FXML
    private JFXDatePicker datePickerNascimento;
    @FXML
    private JFXTextField textFieldCidade;
    @FXML
    private JFXTextField textFieldEndereco;
    @FXML
    private JFXTextField textFieldBairro;
    @FXML
    private JFXTextField textFieldTelefone;
    
    //Atributo para representar o servico
    private ClienteServico servico = new ClienteServico();
    
    @FXML
    private TableView<Cliente> tabela;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colNome;
    @FXML
    private TableColumn colDataNasc;
    @FXML
    private TableColumn colTelefone;
    @FXML
    private TableColumn colCPF;
    @FXML
    private TableColumn colEndereco;
    @FXML
    private TableColumn colBairro;
    
    //Atributo que representa os dados para tabela
    private ObservableList<Cliente> dados
            = FXCollections.observableArrayList();
    
    //Atributo que vai armazenar qual o Cliente 
    //foi selecionado na tabela
    private Cliente selecionado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Configure a tabela
        configurarTabela();

        //Carregue a lista de clientes na tabela
        listarClientesTabela();
    }    

    @FXML
    private void salvar(ActionEvent event) {
        //Verificar se está atualizando ou inserindo
        if(textFieldId.getText().isEmpty()){ //inserindo
            //Pega os dados do fomulário
            //e cria um objeto cliente
            Cliente a = new Cliente(textFieldNome.getText(),
                    textFieldCPF.getText(),
                    datePickerNascimento.getValue(),
                    textFieldEndereco.getText(),
                    textFieldCidade.getText(),
                    textFieldBairro.getText(),
                    textFieldTelefone.getText());

            //Mandar o cliente para a camada de servico
            servico.salvar(a);
            
            //Exibindo mensagem
            mensagemSucesso("Cliente salvo com sucesso!");
            
            //Chama o metodo para atualizar a tabela
            listarClientesTabela();
            
        }else{ //atualizando o cliente
           
            //Pegando a resposta da confirmacao do usuario
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo salvar as alterações?",
                      "EDITAR");
            
            //Se o botão OK foi pressionado
            if(btn.get() == ButtonType.OK){
                //Pegar os novos dados do formulário e
                //atualizar o meu cliente
                selecionado.setNome(textFieldNome.getText());
                
                //Mandando pra camada de serviço salvar as alterações
                servico.editar(selecionado);
                
                //Exibindo mensagem
                mensagemSucesso("Cliente atualizado com sucesso!"); 
                
                //Chama o metodo para atualizar a tabela
                 listarClientesTabela();
            }
    }
    //Limpando o form
        textFieldId.setText("");
        textFieldNome.setText("");
    }
    public void mensagemSucesso(String m) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("SUCESSO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }
    
    /**
     * Exibe uma mensagem de erro
     * @param m 
     */
    public void mensagemErro(String m) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERRO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }
    
     /**
     * Mostra uma caixa com uma mensagem de confirmação
     * onde a pessoa vai poder responder se deseja realizar
     * uma ação
     */
    private Optional<ButtonType> mensagemDeConfirmacao(
            String mensagem, String titulo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        return alert.showAndWait();
    }
    
    /**
     * Fazendo configuração das colunas da tabeça
     */
    private void configurarTabela() {

        //Dizer de onde a coluna vai pegar o valor para
        //exibir, basta dizer o nome do metodo get
        //que deve ser chamado para cada coluna
        // A string entre parênteses é o nome do atributo
        // que vc deseja chamar o get (quase sempre)
        //import javafx.scene.control.cell.PropertyValueFactory;
        colId.setCellValueFactory(
                new PropertyValueFactory("idCliente"));
        colNome.setCellValueFactory(
                new PropertyValueFactory("nome"));
        colDataNasc.setCellValueFactory(
                new PropertyValueFactory("data_nascimento"));
        colTelefone.setCellValueFactory(
                new PropertyValueFactory("telefone"));
        colCPF.setCellValueFactory(
                new PropertyValueFactory("cpf"));
        colEndereco.setCellValueFactory(
                new PropertyValueFactory("endereco"));
        colBairro.setCellValueFactory(
                new PropertyValueFactory("bairro"));

    }//configurarTabela

    /**
     * Responsável por carregar a lista de clientes na tabela
     */
    private void listarClientesTabela() {
        //Limpando quaisquer dados anteriores
        dados.clear();

        //Solicitando a camada de servico a lista de clientes
        List<Cliente> clientes = servico.listar();

        //Transformar a lista de clientes no formato que a tabela
        //do JavaFX aceita
        dados = FXCollections.observableArrayList(clientes);

        //Jogando os dados na tabela
        tabela.setItems(dados);
    
    }
    

    @FXML
    private void editar(ActionEvent event) {
        //Pegar o Cliente que foi selecionado na tabela
        selecionado = tabela.getSelectionModel()
                .getSelectedItem();

        //Se tem algum cliente selecionado
        if (selecionado != null) { //tem cliente selecionado
            //Pegar os dados do cliente e jogar nos campos do
            //formulario
            textFieldId.setText(
                    String.valueOf( selecionado.getIdCliente() ) );
            textFieldNome.setText( selecionado.getNome() );
            textFieldBairro.setText(selecionado.getBairro());
            textFieldCPF.setText(selecionado.getCpf());
            textFieldEndereco.setText(selecionado.getEndereco()
                    +selecionado.getCidade());
            textFieldTelefone.setText(selecionado.getTelefone());
        }else{ //não tem cliente selecionado na tabela
            mensagemErro("Selecione um cliente!");
        }

    }
    

    @FXML
    private void excluir(ActionEvent event) {
        //Pegar o cliente que foi selecionado na tabela
        selecionado = tabela.getSelectionModel()
                .getSelectedItem();
        
        //Verifico se tem cliente selecionado
        if(selecionado != null){ //existe cliente selecionado
            
            //Pegando a resposta da confirmacao do usuario
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            
            //Verificando se apertou o OK
            if(btn.get() == ButtonType.OK){
                
                //Manda para a camada de serviço excluir
                servico.excluir(selecionado);
                
                //mostrar mensagem de sucesso
                mensagemSucesso("Cliente excluído com sucesso!");
                
                //Atualizar a tabela
                listarClientesTabela();              
                
            }
            
        }else{
            mensagemErro("Selecione um cliente!.");
        }
        
    
    }
    
}
