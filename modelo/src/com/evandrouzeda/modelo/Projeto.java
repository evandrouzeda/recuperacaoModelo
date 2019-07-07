/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.evandrouzeda.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author evandrouzeda
 */
@Entity
@Table(name = "projeto")
public class Projeto implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_projeto", sequenceName = "seq_projeto_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_projeto", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome nao pode estar em branco")
    @Length(max = 50, message = "O nome nao pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @NotNull(message = "A descricao não pode ser nulo")
    @NotBlank(message = "A descricao pode estar em branco")
    @Length(max = 100, message = "A descricao nao pode ter mais que {max} caracteres")
    @Column(name = "descriacao", length = 100, nullable = false)
    private String descricao;

    @NotNull(message = "A data de inicio nao pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio", nullable = false)
    private Calendar dataInicio;

    @NotNull(message = "A data do fim nao pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim", nullable = false)
    private Calendar dataFim;

    @NotNull(message = "O valor nao pode ser nulo")
    @Min(message = "O valor nao pode ser negativo", value = 0)
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valor;

    @Type(type = "true_false")
    @Column(name = "ativo")
    private Boolean ativo;

    @NotNull(message = "O tipo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "tipo", referencedColumnName = "id",
            nullable = false, foreignKey = @ForeignKey(name = "fk_tipo_id"))
    private Tipo tipo;

    @NotNull(message = "O departamento deve ser informado")
    @ManyToOne
    @JoinColumn(name = "departamtento", referencedColumnName = "id",
            nullable = false, foreignKey = @ForeignKey(name = "fk_departamento_id"))
    private Departamento departamento;

    public Projeto() {

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Projeto other = (Projeto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
