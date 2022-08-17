package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "transacoes")
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private TransacaoTipo tipo;

    @Enumerated(EnumType.ORDINAL)
    private TransacaoStatus status;

    @ManyToOne(optional = false)
    private Pessoa pessoa;

    @ManyToOne
    private Usuario operador;

    @ManyToOne
    private Usuario usuarioUltimaAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransacao;

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAlteracao;

    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "transacao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TransacaoItem> itens;

    @Enumerated(EnumType.ORDINAL)
    private FormaPagamento pagamento;

    public Transacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(TransacaoTipo tipo) {
        this.tipo = tipo;
    }

    public TransacaoStatus getStatus() {
        return status;
    }

    public void setStatus(TransacaoStatus status) {
        this.status = status;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Usuario getOperador() {
        return operador;
    }

    public void setOperador(Usuario operador) {
        this.operador = operador;
    }

    public Usuario getUsuarioUltimaAlteracao() {
        return usuarioUltimaAlteracao;
    }

    public void setUsuarioUltimaAlteracao(Usuario usuarioUltimaAlteracao) {
        this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<TransacaoItem> getItens() {
        return itens;
    }

    public void setItens(List<TransacaoItem> itens) {
        this.itens = itens;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataTransacao == null) ? 0 : dataTransacao.hashCode());
        result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((itens == null) ? 0 : itens.hashCode());
        result = prime * result + ((operador == null) ? 0 : operador.hashCode());
        result = prime * result + ((pagamento == null) ? 0 : pagamento.hashCode());
        result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((usuarioUltimaAlteracao == null) ? 0 : usuarioUltimaAlteracao.hashCode());
        result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transacao other = (Transacao) obj;
        if (dataTransacao == null) {
            if (other.dataTransacao != null)
                return false;
        } else if (!dataTransacao.equals(other.dataTransacao))
            return false;
        if (dataUltimaAlteracao == null) {
            if (other.dataUltimaAlteracao != null)
                return false;
        } else if (!dataUltimaAlteracao.equals(other.dataUltimaAlteracao))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (itens == null) {
            if (other.itens != null)
                return false;
        } else if (!itens.equals(other.itens))
            return false;
        if (operador == null) {
            if (other.operador != null)
                return false;
        } else if (!operador.equals(other.operador))
            return false;
        if (pagamento != other.pagamento)
            return false;
        if (pessoa == null) {
            if (other.pessoa != null)
                return false;
        } else if (!pessoa.equals(other.pessoa))
            return false;
        if (status != other.status)
            return false;
        if (tipo != other.tipo)
            return false;
        if (usuarioUltimaAlteracao == null) {
            if (other.usuarioUltimaAlteracao != null)
                return false;
        } else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
            return false;
        if (valorTotal == null) {
            if (other.valorTotal != null)
                return false;
        } else if (!valorTotal.equals(other.valorTotal))
            return false;
        return true;
    }

    
}
