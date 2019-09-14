package VO;

public class ProdutoVO extends PadraoVO {

    private String tamanho;
    private String cor;
    private String descricao;
    private double preco;

    public ProdutoVO(){
        definicaoVO = "Produto";
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {

        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) throws Exception {
        if (cor.length() == 0)
            throw new Exception("Informe uma cor para " + definicaoVO);
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws Exception {
        if (preco <= 0.00)
            throw new Exception("Forneça um preço válido para " + definicaoVO);
        else
            this.preco = preco;
    }
}
