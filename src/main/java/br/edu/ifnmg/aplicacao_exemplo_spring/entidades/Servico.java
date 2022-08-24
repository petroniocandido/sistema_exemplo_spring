package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(name = "ServicosInsumos",
        joinColumns = @JoinColumn(name="ServicoID"), 
        inverseJoinColumns = @JoinColumn(name="ProdutoID"))
    public List<Produto> insumos;

    public Servico(){
        super();
        this.setTipo(AtivoTipo.Servico);
    }
}
