package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PessoasJuridicas")
@DiscriminatorValue("2")
@Getter @Setter @AllArgsConstructor 
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((representante == null) ? 0 : representante.hashCode());
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
        PessoaJuridica other = (PessoaJuridica) obj;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        if (representante == null) {
            if (other.representante != null)
                return false;
        } else if (!representante.equals(other.representante))
            return false;
        return true;
    }


    
}


