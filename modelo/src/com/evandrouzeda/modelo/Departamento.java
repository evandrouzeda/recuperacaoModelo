/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author evandrouzeda
 */

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_departamento", sequenceName = "seq_departemento_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_departamento", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome nao pode estar em branco")
    @Length(max = 50, message = "O nome nao pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @NotNull(message = "O nome do responsavel não pode ser nulo")
    @NotBlank(message = "O nome do responsavel nao pode estar em branco")
    @Length(max = 50, message = "O nome do responsavel nao pode ter mais que {max} caracteres")
    @Column(name = "responsavel", length = 50, nullable = false)
    private String responsavel;
    
    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone nao pode estar em branco")
    @Length(max = 11, message = "O telefone nao pode ter mais que {max} caracteres")
    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    public Departamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
