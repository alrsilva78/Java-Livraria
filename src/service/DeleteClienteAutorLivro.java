package service;

import java.util.Scanner;

import model.Main;

public class DeleteClienteAutorLivro {

    private String nomeDelete;

    public void deleteClienteAutor(){

        ListarMetodos.listaPessoas();

        if (CadastroDePessoas.getListaPessoas().isEmpty()) {
            System.out.println();
            Main.main(null);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome para Exclusão: ");
        setNomeDelete(scanner.nextLine().trim()); 

        // setNomeDoLivroParaCompra(getVenda());

        // boolean livroEncontrado = false;
        
        // // Percorre a lista de livros cadastrados
        // for (model.Produto livro : CadastroDeLivros.getListaLivros()) {
        //     // Comparação ignorando maiúsculas/minúsculas e removendo espaços em branco
        //     if (livro.getNomeDoLivro().trim().equalsIgnoreCase(getNomeDoLivroParaCompra())) {
        //         livroEncontrado = true;
        //         if (livro.getEstoqueDoLivro() > 0) {
        //             // Realiza a venda, subtrai uma unidade do estoque
        //             livro.setEstoqueDoLivro(livro.getEstoqueDoLivro() - 1);
        //             System.out.println("Venda realizada! Estoque atual de '" + livro.getNomeDoLivro() + "': " + livro.getEstoqueDoLivro());
        //         } else {
        //             System.out.println("Não é possível realizar a venda. O livro '" + livro.getNomeDoLivro() + "' está sem estoque.");
        //         }
        //         break; // Interrompe o loop após encontrar o livro
        //     }
        // }

        // // Mensagem caso o livro não seja encontrado
        // if (!livroEncontrado) {
        //     System.out.println("O livro '" + nomeDoLivroParaCompra + "' não foi encontrado no catálogo.");
        // }
    }

    public String getNomeDelete() {
        return nomeDelete;
    }
    public void setNomeDelete(String nomeDelete) {
        this.nomeDelete = nomeDelete;
    }
};

