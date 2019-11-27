/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.entidades;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author IFNMG
 */
public class FichaMedica {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Integer idFichaMedica;
      private String veterinario;
      private LocalDate dataAtendimento;
      private String atendimentos;
      
      //jpa
    public FichaMedica(){}

    public FichaMedica(String veterinario, LocalDate dataAtendimento, String atendimentos, Cachorro cao) {
        this.veterinario = veterinario;
        this.dataAtendimento = dataAtendimento;
        this.atendimentos = atendimentos;
        this.cao = cao;
    }
    
    @ManyToOne(optional=true)
    private Cachorro cao;

    public Integer getIdFichaMedica() {
        return idFichaMedica;
    }

    public void setIdFichaMedica(Integer idFichaMedica) {
        this.idFichaMedica = idFichaMedica;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(String atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Cachorro getCao() {
        return cao;
    }

    public void setCao(Cachorro cao) {
        this.cao = cao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idFichaMedica);
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
        final FichaMedica other = (FichaMedica) obj;
        if (!Objects.equals(this.idFichaMedica, other.idFichaMedica)) {
            return false;
        }
        return true;
    }
    
    
}
