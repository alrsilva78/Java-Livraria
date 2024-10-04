package service;

// Classe que realiza a Venda de Livros

import java.util.Scanner;
import interfaces.TotalPagar;
import java.util.List;
import java.util.ArrayList;

public class Venda implements TotalPagar {

    private String venda;
    private String nomeDoLivroParaCompra;

    // Implementação do método pagamento da interface TotalPagar
    @Override
    public void pagamento() {
        System.out.println("Processando o pagamento...");
    }


    public void realizarVenda() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nome do Livro: ");
            setVenda(scanner.nextLine().trim());
            setNomeDoLivroParaCompra(getVenda());

            if (!processarVenda(scanner)) {
                // Se não encontrar livro, continuar perguntando
                System.out.printf("O livro " + nomeDoLivroParaCompra + " não foi encontrado no catálogo.\n");
            } else {
                break; // Venda realizada com sucesso
            }
        }
    }

    private boolean processarVenda(Scanner scanner) {
        List<model.Produto> livrosEncontrados = new ArrayList<>();

        // Coletar todos os livros com o mesmo nome
        for (model.Produto livro : CadastroDeLivros.getListaLivros()) {
            if (livro.getNomeDoLivro().trim().equalsIgnoreCase(getNomeDoLivroParaCompra())) {
                livrosEncontrados.add(livro);
            }
        }

        if (livrosEncontrados.isEmpty()) {
            return false; // Livro não encontrado
        }

        // Se houver livros com o mesmo nome, permitir a escolha do livro
        return realizarTransacao(scanner, livrosEncontrados);
    }

    private boolean realizarTransacao(Scanner scanner, List<model.Produto> livros) {
        // Exibir todos os livros disponíveis e seus estoques
        for (int i = 0; i < livros.size(); i++) {
            model.Produto livro = livros.get(i);
            System.out.println((i + 1) + ". " + livro.getNomeDoLivro() + " - Autor: " + livro.getNomeDoAutor() + " - Editora: " + livro.getNomeDaEditora() +  " - Estoque: " + livro.getEstoqueDoLivro());
        }

        // Perguntar ao usuário qual livro ele deseja comprar
        System.out.print("Escolha o número do livro que deseja comprar: ");
        int escolha = Integer.parseInt(scanner.nextLine()) - 1;

        // Validar a escolha
        if (escolha < 0 || escolha >= livros.size()) {
            System.out.println("Escolha inválida.");
            return false;
        }

        model.Produto livroSelecionado = livros.get(escolha);

        if (livroSelecionado.getEstoqueDoLivro() <= 0) {
            System.out.println();
            System.out.printf("Não é possível realizar a venda. O livro " + livroSelecionado.getNomeDoLivro() + " - Editora: " + livroSelecionado.getNomeDaEditora() +  " está sem estoque.");
            System.out.println();
            return true; // Livro encontrado, mas sem estoque
        }

        // Realizar a venda diretamente
        livroSelecionado.setEstoqueDoLivro(livroSelecionado.getEstoqueDoLivro() - 1);
        System.out.println();
        System.out.println("Venda realizada! Estoque atual de '" + livroSelecionado.getNomeDoLivro() + " - Editora: " + livroSelecionado.getNomeDaEditora() + "': " + livroSelecionado.getEstoqueDoLivro());
       // Implementação do método pagamento e totalPagar da interface TotalPagar
        pagamento();
        totalPagar(livroSelecionado.getValorDoLivro());
        
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
}
