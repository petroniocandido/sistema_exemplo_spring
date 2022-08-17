package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PessoasFisicas")
@DiscriminatorValue("1")
@Getter @Setter @AllArgsConstructor @EqualsAndHashCode
public class PessoaFisica extends Pessoa {
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    public PessoaFisica(){
        super();
        setTipo(PessoaTipo.Fisica);
        this.cpf = "";
        this.dataNascimento = new Date();
    }
}


