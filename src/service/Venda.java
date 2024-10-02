package service;

import java.util.Scanner;
import interfaces.TotalPagar;

public class Venda implements TotalPagar {

    private String venda;
    private String nomeDoLivroParaCompra;

    public void totalPagar (){
    }

    public void totalPagar (double valor){
        System.out.println( "Valor total a pagar = R$" + valor);
    }

    public void venda() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do Livro: ");
        setVenda(scanner.nextLine().trim()); 
        System.out.println();

        setNomeDoLivroParaCompra(getVenda());

        boolean livroEncontrado = false;
        
        // Percorre a lista de livros cadastrados
        for (model.Produto livro : CadastroDeLivros.getListaLivros()) {
            // Comparação ignorando maiúsculas/minúsculas e removendo espaços em branco
            if (livro.getNomeDoLivro().trim().equalsIgnoreCase(getNomeDoLivroParaCompra())) {
                livroEncontrado = true;
                if (livro.getEstoqueDoLivro() > 0) {
                    // Realiza a venda, subtrai uma unidade do estoque
                    livro.setEstoqueDoLivro(livro.getEstoqueDoLivro() - 1);
                    System.out.println("Venda realizada! Estoque atual de '" + livro.getNomeDoLivro() + "': " + livro.getEstoqueDoLivro());
                    totalPagar(livro.getValorDoLivro());
                } else {
                    System.out.println("Não é possível realizar a venda. O livro '" + livro.getNomeDoLivro() + "' está sem estoque.");
                }
                break; // Interrompe o loop após encontrar o livro
            }
        }

        // Mensagem caso o livro não seja encontrado
        while (!livroEncontrado) {
            System.out.println("O livro '" + nomeDoLivroParaCompra + "' não foi encontrado no catálogo.");
            System.out.println();
            System.out.print("Escolha outro Livro: ");
            setVenda(scanner.nextLine().trim());
            setNomeDoLivroParaCompra(getVenda());
            System.out.println();

            livroEncontrado = false;
        
        // Percorre a lista de livros cadastrados
        for (model.Produto livro : CadastroDeLivros.getListaLivros()) {
            // Comparação ignorando maiúsculas/minúsculas e removendo espaços em branco
            if (livro.getNomeDoLivro().trim().equalsIgnoreCase(getNomeDoLivroParaCompra())) {
                livroEncontrado = true;
                if (livro.getEstoqueDoLivro() > 0) {
                    // Realiza a venda, subtrai uma unidade do estoque
                    livro.setEstoqueDoLivro(livro.getEstoqueDoLivro() - 1);
                    System.out.println("Venda realizada! Estoque atual de '" + livro.getNomeDoLivro() + "': " + livro.getEstoqueDoLivro());
                    totalPagar(livro.getValorDoLivro());
                } else {
                    System.out.println("Não é possível realizar a venda. O livro '" + livro.getNomeDoLivro() + "' está sem estoque.");
                }
                break; // Interrompe o loop após encontrar o livro
            }
        }

        }
    }


    public String getNomeDoLivroParaCompra() {
        return nomeDoLivroParaCompra;
    }

    public void setNomeDoLivroParaCompra(String nomeDoLivroParaCompra) {
        this.nomeDoLivroParaCompra = nomeDoLivroParaCompra;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }
}
