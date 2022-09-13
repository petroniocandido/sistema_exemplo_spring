package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Produtos")
@DiscriminatorValue("1")
@Getter @Setter
public class Produto extends Ativo {

    private String unidadeCompra;

    private String unidadeVenda;

    public Produto(){
        super();
        this.setTipo(AtivoTipo.Servico);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((unidadeCompra == null) ? 0 : unidadeCompra.hashCode());
        result = prime * result + ((unidadeVenda == null) ? 0 : unidadeVenda.hashCode());
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
        Produto other = (Produto) obj;
        if (unidadeCompra == null) {
            if (other.unidadeCompra != null)
                return false;
        } else if (!unidadeCompra.equals(other.unidadeCompra))
            return false;
        if (unidadeVenda == null) {
            if (other.unidadeVenda != null)
                return false;
        } else if (!unidadeVenda.equals(other.unidadeVenda))
            return false;
        return true;
    }

    

}
