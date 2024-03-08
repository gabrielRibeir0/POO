package Ficha3;
public class LinhaEncomenda {
    private String referencia;
    private String descricaoProduto;
    private int precoOriginal;
    private int quantidade;
    private int percentagemImposto;
    private int percentagemDesconto;

    public LinhaEncomenda(){
        this.referencia = "";
        this.descricaoProduto = "";
        this.precoOriginal = 0;
        this.quantidade = 0;
        this.percentagemImposto = 0;
        this.percentagemDesconto = 0;
    }

    public LinhaEncomenda(String referencia, String descricao, int preco , int quantidade, int imposto , int desconto){
        this.referencia = referencia;
        this.descricaoProduto = descricao;
        this.precoOriginal = preco;
        this.quantidade = quantidade;
        this.percentagemImposto = imposto;
        this.percentagemDesconto = desconto;
    }

    public LinhaEncomenda(LinhaEncomenda linha){
        this.referencia = linha.referencia;
        this.descricaoProduto = linha.descricaoProduto;
        this.precoOriginal = linha.precoOriginal;
        this.quantidade = linha.quantidade;
        this.percentagemImposto = linha.percentagemImposto;
        this.percentagemDesconto = linha.percentagemDesconto;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public String getDescricaoProduto() {
        return this.descricaoProduto;
    }

    public int getPrecoOriginal() {
        return this.precoOriginal;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public int getPercentagemImposto() {
        return this.percentagemImposto;
    }

    public int getPercentagemDesconto() {
        return this.percentagemDesconto;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public void setPrecoOriginal(int precoOriginal) {
        this.precoOriginal = precoOriginal;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setPercentagemImposto(int percentagemImposto) {
        this.percentagemImposto = percentagemImposto;
    }

    public void setPercentagemDesconto(int percentagemDesconto) {
        this.percentagemDesconto = percentagemDesconto;
    }

    public double calculaValorLinhaEnc(){
        double desconto = this.calculaValorDesconto();
        double imposto = this.precoOriginal * this.percentagemImposto * 0.01;
        return this.precoOriginal - desconto + imposto;
    }

    public double calculaValorDesconto(){
        return this.precoOriginal * this.percentagemDesconto * 0.01;
    }

    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        LinhaEncomenda linha = (LinhaEncomenda) obj;
        return (this.referencia.equals(linha.referencia) && this.descricaoProduto.equals(linha.descricaoProduto) && this.precoOriginal == linha.precoOriginal && this.quantidade == linha.quantidade && this.percentagemImposto == linha.percentagemImposto && this.percentagemDesconto == linha.percentagemDesconto);
    }

    public String toString(){
        return "Referência: " + this.referencia + " | Descrição produto: " + this.descricaoProduto + " | Preço antes de impostos: " + this.precoOriginal + " | Quantidade: " + this.quantidade + " | Imposto: " + this.percentagemImposto + "% | Desconto: " + this.percentagemDesconto + "%";
    }

    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }
}
