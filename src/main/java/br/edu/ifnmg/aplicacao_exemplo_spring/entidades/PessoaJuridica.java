package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PessoasJuridicas")
@DiscriminatorValue("2")
@Getter @Setter @AllArgsConstructor @EqualsAndHashCode
public class PessoaJuridica extends Pessoa {
    @Column(length = 14, nullable = false, unique = true)
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "RepresentanteID")
    private Pessoa representante;

    public PessoaJuridica(){
        super();
        setTipo(PessoaTipo.Juridica);
        this.cnpj = "";
        this.representante = null;
    }
}


