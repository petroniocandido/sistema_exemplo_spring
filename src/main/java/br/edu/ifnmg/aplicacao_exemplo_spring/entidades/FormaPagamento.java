package br.edu.ifnmg.aplicacao_exemplo_spring.entidades;

public enum FormaPagamento {
    Dinheiro("À vista em dinheiro"),
    CartaoDebito("À vista no Cartão de Débito"),
    CartaoCredito("À prazo no Cartão de Crédito"),
    Pix("À vista por Pix"),
    Boleto("À prazo em Boleto"),
    ChequeAVista("À vista em Cheque"),
    ChequePreDatado("À prazo em Cheque");

    private String descricao;

    private FormaPagamento(String d){
        this.descricao = d;
    }

    @Override
    public String toString(){
        return this.descricao;
    }
}
