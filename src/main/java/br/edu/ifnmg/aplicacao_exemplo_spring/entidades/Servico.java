package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Servicos")
@DiscriminatorValue("2")
@Getter @Setter 
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((insumos == null) ? 0 : insumos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Servico other = (Servico) obj;
        if (insumos == null) {
            if (other.insumos != null)
                return false;
        } else if (!insumos.equals(other.insumos))
            return false;
        return true;
    }

    
}
