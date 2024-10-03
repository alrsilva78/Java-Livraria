package service;

import java.util.Scanner;
import interfaces.TotalPagar;
import java.util.List;
import java.util.ArrayList;

public class Venda implements TotalPagar {

    private String venda;
    private String nomeDoLivroParaCompra;
    private String nomeEditoraVenda;

    // Implementando interface
    public void totalPagar() {}

    public void totalPagar(double valor) {
        System.out.println("Valor total a pagar = R$" + valor);
    }

    public void realizarVenda() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nome do Livro: ");
            setVenda(scanner.nextLine().trim());
            setNomeDoLivroParaCompra(getVenda());

            if (!processarVenda(scanner)) {
                System.out.printf("O livro " + nomeDoLivroParaCompra + " não foi encontrado no catálogo.");
            } else {
                break; // Venda realizada com sucesso
            }
        }
    }

    private boolean processarVenda(Scanner scanner) {
        for (model.Produto livro : CadastroDeLivros.getListaLivros()) {
            if (livro.getNomeDoLivro().trim().equalsIgnoreCase(getNomeDoLivroParaCompra())) {
                return realizarTransacao(scanner, livro);
            }
        }
        return false; // Livro não encontrado
    }

    private boolean realizarTransacao(Scanner scanner, model.Produto livro) {
        if (livro.getEstoqueDoLivro() <= 0) {
            System.out.printf("Não é possível realizar a venda. O livro " + livro.getNomeDoLivro() + " está sem estoque.");
            return true; // Livro encontrado, mas sem estoque
        }

        List<String> editorasDisponiveis = new ArrayList<>();
        editorasDisponiveis.add(livro.getNomeDaEditora());

        boolean escolheEditora = false;
        while (!escolheEditora) {
            System.out.println("Escolha uma Editora da lista: ");
            editorasDisponiveis.forEach(editora -> System.out.println("Editora: " + editora));

            System.err.print("Nome da Editora: ");
            setNomeEditoraVenda(scanner.nextLine());
            System.out.println();

            if (editorasDisponiveis.contains(getNomeEditoraVenda())) {
                livro.setEstoqueDoLivro(livro.getEstoqueDoLivro() - 1);
                System.out.println("Venda realizada! Estoque atual de '" + livro.getNomeDoLivro() + " Editora: " + getNomeEditoraVenda() + "': " + livro.getEstoqueDoLivro());
                totalPagar(livro.getValorDoLivro());
                escolheEditora = true;
            } else {
                System.out.println("A Editora " + getNomeEditoraVenda() + " não faz parte da lista...");
                System.out.println();
            }
        }
        return true; // Venda realizada
    }
    
    // Getters e Setters
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

    public String getNomeEditoraVenda() {
        return nomeEditoraVenda;
    }

    public void setNomeEditoraVenda(String nomeEditoraVenda) {
        this.nomeEditoraVenda = nomeEditoraVenda;
    }
}
