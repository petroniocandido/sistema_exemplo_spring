package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Produtos")
@DiscriminatorValue("1")
@Getter @Setter @EqualsAndHashCode
public class Produto extends Ativo {
    public Produto(){
        super();
        this.setTipo(AtivoTipo.Servico);
    }
}
