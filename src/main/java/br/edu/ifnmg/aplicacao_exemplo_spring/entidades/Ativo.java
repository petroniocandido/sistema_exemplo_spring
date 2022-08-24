package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ativos")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.INTEGER)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(insertable = false, updatable = false)
    private AtivoTipo tipo;

    private String nome;

    private String descricao;

    private BigDecimal valorCusto;

    private BigDecimal valorVenda;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cadastro;

    @ManyToOne
    private Usuario usuarioCriador;

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaAlteracao;

    @ManyToOne
    private Usuario ultimoAlterador;
}
