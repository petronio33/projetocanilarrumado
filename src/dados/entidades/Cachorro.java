/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author IFNMG
 */
@Entity
public class Cachorro{
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idCachorro;
    private String raça;
    private String nome;
    private String porte;
    private String sexo;
    private String observacao;

    //jpa
    public Cachorro(){}
    
    
    public Cachorro (String nome, String raça, String obs ){
        this.setNome(nome);
        this.setRaça(raça);
        this.setObservacao(obs);
        
       
        
    }
            
    @ManyToMany
    private List<Cliente> dono =new ArrayList<Cliente>();

    public List<Cliente> getDono() {
        return dono;
    }

    public void setDono(List<Cliente> dono) {
        this.dono = dono;
    }

    public Integer getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(Integer idCachorro) {
        this.idCachorro = idCachorro;
    }

    public String getRaça() {
        return raça;
    }

    public void setRaça(String raça) {
        this.raça = raça;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.idCachorro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cachorro other = (Cachorro) obj;
        if (!Objects.equals(this.idCachorro, other.idCachorro)) {
            return false;
        }
        return true;
    }


}
