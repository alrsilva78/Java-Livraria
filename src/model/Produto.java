package model;


// Classe abstract com atributos para Produto/Livro


public abstract class Produto {

    private String nomeDoLivro;
    private String nomeDoAutor;
    private String nomeDaEditora;
    private String dataDaPublicacao;
    private double valorDoLivro;
    private int estoqueDoLivro;

    // Construtor
    public Produto(String nomeDoLivro, String nomeDoAutor, String nomeDaEditora, String dataDaPublicacao, double valorDoLivro, int estoqueDoLivro) {
        this.nomeDoLivro = nomeDoLivro;
        this.nomeDoAutor = nomeDoAutor;
        this.nomeDaEditora = nomeDaEditora;
        this.dataDaPublicacao = dataDaPublicacao;
        this.valorDoLivro = valorDoLivro;
        this.estoqueDoLivro = estoqueDoLivro;
    }

    // Getters
    public String getNomeDoLivro() {
        return nomeDoLivro;
    }

    public String getNomeDoAutor() {
        return nomeDoAutor;
    }

    public String getNomeDaEditora() {
        return nomeDaEditora;
    }

    public String getDataDaPublicacao() {
        return dataDaPublicacao;
    }

    public double getValorDoLivro() {
        return valorDoLivro;
    }

    public int getEstoqueDoLivro() {
        return estoqueDoLivro;
    }

    // Método para atualizar o estoque do livro
    public void setEstoqueDoLivro(int estoqueDoLivro) {
        this.estoqueDoLivro = estoqueDoLivro;
    }
}
