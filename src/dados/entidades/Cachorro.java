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
    private String raca;
    private String nome;
    private String porte;
    private String sexo;
    private String observacao;

    //jpa
    public Cachorro(){}

    public Cachorro(String raca, String nome, String porte, String sexo, String observacao, Cliente dono) {
        this.raca = raca;
        this.nome = nome;
        this.porte = porte;
        this.sexo = sexo;
        this.observacao = observacao;
        this.dono = dono;
    }

  
            
    @ManyToOne(optional=false)
    private Cliente dono ;

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }



    public Integer getIdCachorro() {
        return idCachorro;
    }

    public void setIdCachorro(Integer idCachorro) {
        this.idCachorro = idCachorro;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
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
