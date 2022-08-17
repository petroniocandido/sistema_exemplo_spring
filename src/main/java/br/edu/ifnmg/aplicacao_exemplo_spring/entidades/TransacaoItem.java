package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TransacoesItens")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class TransacaoItem implements Serializable {

    @Id 
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "TransacaoID"))
    private Transacao transacao;

    @Id
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "AtivoID"))
    private Ativo ativo;

    private int quantidade;

    private BigDecimal valorUnitario;
    
}
