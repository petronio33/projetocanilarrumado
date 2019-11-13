package dados.daos;

import dados.entidades.Cachorro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class CachorroDAO {
    
    /**
     * Salvar o Cachorro no BD
     */
    public void salvar(Cachorro c) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Mandar persistir o cliente
        gerenciador.persist(c);

        //Commit
        gerenciador.getTransaction().commit();

    }

    /**
     * Retorna uma lista com todos os cliente que estejam cadastrados no banco de
     * dados
     *
     * @return
     */
    public List<Cachorro> listar() {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();

        //Criando a consulta ao BD
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Cachorro a", Cachorro.class);

        //Retornar a lista de Cachorro
        return consulta.getResultList();

    }

    /**
     * Salva as alterações no BD
     */
    public void editar(Cachorro c) {

        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();

        //Mandar sincronizar as alterações 
        gerenciador.merge(c);
        
        //Commit na transação
        gerenciador.getTransaction().commit();

    }
    
    /**
     * Exclui o Cachorro do BD
     */
    public void excluir(Cachorro c){
        
        //Pegando o gerenciador de acesso ao BD
        EntityManager gerenciador = JPAUtil.getGerenciador();
        
        //Iniciar a transação
        gerenciador.getTransaction().begin();
        
        //Para excluir tem que dar o merge primeiro para 
        //sincronizar o ator do BD com o ator que foi
        //selecionado na tela
        c = gerenciador.merge(c);

        //Mandar sincronizar as alterações 
        gerenciador.remove(c);
        
        //Commit na transação
        gerenciador.getTransaction().commit();
        
    }
}
