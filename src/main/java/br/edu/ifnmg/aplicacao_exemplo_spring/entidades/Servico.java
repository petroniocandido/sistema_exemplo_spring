package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

//import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Servicos")
@DiscriminatorValue("2")
@Getter @Setter  @EqualsAndHashCode
public class Servico extends Ativo {
    public Servico(){
        super();
        this.setTipo(AtivoTipo.Servico);
    }
}
