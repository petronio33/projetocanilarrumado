package servicos;

import dados.daos.CachorroDAO;
import dados.entidades.Cachorro;
import java.util.List;

/**
 *
 * @author IFNMG
 */

public class CachorroServico {
    
//Atributo para representar a camada de dados
    private CachorroDAO dao = new CachorroDAO();
    
    public void salvar(Cachorro c){
        //Fazer qualquer regra de negócio
        
        //Mandar o Cachorro para a camada de dados
        //para ser salvo no banco de dados
        dao.salvar(c);
    }
    
    /**
     * Solicita a camada DAO para buscar os Cachorros
     * cadastrados
     * @return 
     */
    public List<Cachorro> listar(){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Pedir a DAO para listar e retornar
        return dao.listar();
        
    }
    
    /**
     * Recebe um cliente e manda para a camada DAO atualizar 
     */
    public void editar(Cachorro c){
        
        //Qualquer regra de negócio (se aplicável)
        
        
        //Mandar a DAO atualizar os dados no BD
        dao.editar(c);
        
    }
    
    /**
     *  Recebe um Cachorro para passar para a DAO excluir no BD
     */
    public void excluir(Cachorro c){
        
        //Qualquer regra de negócio (se aplicável)
        
        //Mandar para a DAO excluir
        dao.excluir(c);
    }
}

   
