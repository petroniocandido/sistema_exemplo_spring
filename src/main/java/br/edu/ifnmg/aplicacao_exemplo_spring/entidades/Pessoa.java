package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "nome", length = 500, nullable = false)
    private String nome;

    @Enumerated(EnumType.ORDINAL)
    private PessoaTipo tipo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
    private List<Telefone> telefones;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PessoasContatos",
    joinColumns = @JoinColumn(name="PessoaID"), 
    inverseJoinColumns = @JoinColumn(name="ContatoID"))
    private List<Pessoa> contatos;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "usuarioCriadorID")
    private Usuario criador;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "usuarioModificadorID")
    private Usuario ultimoModificador;

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaModificacao;

    public Pessoa() {
        this.id = 0L;
        this.nome = "";
        this.tipo = PessoaTipo.Fisica;
        this.telefones = new ArrayList<>();
        this.contatos = new ArrayList<>();
        this.criador = null;
        this.ultimoModificador = null;
        this.dataCriacao = new Date();
        this.dataUltimaModificacao = null;
    }

    public Pessoa(long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.tipo = PessoaTipo.Fisica;
        this.telefones = new ArrayList<>();
        this.criador = null;
        this.ultimoModificador = null;
        this.dataCriacao = null;
        this.dataUltimaModificacao = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Pessoa other = (Pessoa) obj;
        if (id != other.id)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + "]";
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void add(Telefone t){
        if(!this.telefones.contains(t)){
            t.setPessoa(this);
            this.telefones.add(t);
        }
    }

    public void remove(Telefone t){
        if(this.telefones.contains(t)){
            this.telefones.remove(t);
        }
    }

    public PessoaTipo getTipo() {
        return tipo;
    }

    public void setTipo(PessoaTipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUltimoModificador() {
        return ultimoModificador;
    }

    public void setUltimoModificador(Usuario ultimoModificador) {
        this.ultimoModificador = ultimoModificador;
    }

    public Date getDataUltimaModificacao() {
        return dataUltimaModificacao;
    }

    public void setDataUltimaModificacao(Date dataUltimaModificacao) {
        this.dataUltimaModificacao = dataUltimaModificacao;
    }

    public List<Pessoa> getContatos() {
        return contatos;
    }

    public void setContatos(List<Pessoa> contatos) {
        this.contatos = contatos;
    }

    
    
}
