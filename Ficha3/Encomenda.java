package Ficha3;
import java.time.LocalDate;
import java.util.Arrays;

public class Encomenda {
    private String nomeCliente;
    private int numFiscal;
    private String morada;
    private int numEncomenda;
    private LocalDate dataEncomenda;
    private LinhaEncomenda[] linhas;
    private int linhasAdicionadas;

    public Encomenda(){
        this.nomeCliente = "";
        this.numFiscal = 0;
        this.morada = "";
        this.numEncomenda = 0;
        this.linhas = new LinhaEncomenda[50];
        this.dataEncomenda = null;
        this.linhasAdicionadas = 0;
    }

    public Encomenda(String nome, int numFiscal, String morada, int numEncomenda, LocalDate data, LinhaEncomenda[] linhas, int linhasAdicionadas){
        this.nomeCliente = nome;
        this.numFiscal = numFiscal;
        this.morada = morada;
        this.numEncomenda = numEncomenda;
        this.dataEncomenda = data;
        this.linhas = Arrays.copyOf(linhas, linhas.length);
        this.linhasAdicionadas = linhasAdicionadas;
    }

    public Encomenda(Encomenda encomenda){
        this.nomeCliente = encomenda.nomeCliente;
        this.numFiscal = encomenda.numFiscal;
        this.morada = encomenda.morada;
        this.numEncomenda = encomenda.numEncomenda;
        this.linhas = Arrays.copyOf(encomenda.linhas, encomenda.linhas.length);
        this.dataEncomenda = encomenda.dataEncomenda;
        this.linhasAdicionadas = encomenda.linhasAdicionadas;
    }

    public int getNumEncomenda() {
        return numEncomenda;
    }

    public int getNumFiscal() {
        return numFiscal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getMorada() {
        return morada;
    }

    public LinhaEncomenda[] getLinhas() {
        return Arrays.copyOf(this.linhas, this.linhas.length);
    }

    public LocalDate getDataEncomenda() {
        return dataEncomenda;
    }

    public void setNumFiscal(int numFiscal){
        this.numFiscal = numFiscal;
    }

    public void setLinhas(LinhaEncomenda[] linhas){
        this.linhas = Arrays.copyOf(linhas, linhas.length);
    }

    public void setDataEncomenda(LocalDate dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setNumEncomenda(int numEncomenda) {
        this.numEncomenda = numEncomenda;
    }

    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }

        Encomenda encomenda = (Encomenda) obj;
        //TODO
        return (this.numFiscal == encomenda.numFiscal && this.numEncomenda == encomenda.numEncomenda);
    }

    public double calculaValorTotal(){
        double valorTotal = 0;
        for(int i = 0; i < this.linhas.length; i++){
            valorTotal += this.linhasdouble descontoTotal = 0;
        for(int i = 0; i < this.linhas.length; i++){
            descontoTotal += this.linhas.calculaValorDesconto();
        }

        return descontoTotal;[i].calculaValorLinhaEnc();
        }

        return valorTotal;
    }

    public double calculaValorDesconto(){
        double descontoTotal = 0;
        for(int i = 0; i < this.linhas.length; i++){
            descontoTotal += this.linhas[i].calculaValorDesconto();
        }

        return descontoTotal;
    }

    public int numeroTotalProdutos(){
        int totalProdutos = 0;
        for(int i = 0; i < this.linhas.length; i++){
            totalProdutos += this.linhas[i].getQuantidade();
        }

        return totalProdutos;
    }

    public boolean existeProdutoEncomenda(String refProduto){
        for(int i = 0; i < this.linhas.length; i++){
            if(refProduto.equals(this.linhas[i].getReferencia())){
                return true;
            }
        }
        return false;
    }

    public void adicionaLinha(LinhaEncomenda linha){
        if(this.linhasAdicionadas >= this.linhas.length){
            this.linhas = Arrays.copyOf(this.linhas, this.linhas.length * 2);
        }
        LinhaEncomenda novaLinha = linha.clone();
        this.linhas[this.linhasAdicionadas] = novaLinha;
        this.linhasAdicionadas++;
    }
}