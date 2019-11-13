/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados.entidades;

import java.time.LocalDate;

/**
 *
 * @author IFNMG
 */
public class FichaMedica{
    private String medicamento;
    private LocalDate data_validade;
    private String vacinas;
    private Cachorro cao;
    private String veterinario;

    public Cachorro getCao() {
        return cao;
    }

    public void setCao(Cachorro cao) {
        this.cao = cao;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }


    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public LocalDate getData_validade() {
        return data_validade;
    }

    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }

    public String getVacinas() {
        return vacinas;
    }

    public void setVacinas(String vacinas) {
        this.vacinas = vacinas;
    }
    
}
