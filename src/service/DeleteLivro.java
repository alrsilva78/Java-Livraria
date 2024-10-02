package service;

import java.util.Iterator;
import java.util.Scanner;
import model.Main;


public class DeleteLivro {


    private String livroDelete;

    public void deleteLivro (){

        ListarMetodos.listaLivros();

        if (CadastroDeLivros.getListaLivros().isEmpty()){
            System.out.println();
            Main.main(null);

        }

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Nome do Livro para exclusão: ");
        setLivroDelete(scanner.nextLine().trim());

        if (removerLivroPorNome(getLivroDelete())) {
            System.out.println("Livro " + getLivroDelete() + " excluído com sucesso!");    
        }else {
            System.out.println("Livro " + getLivroDelete() + " não encontrado.");
        }
    }

    private boolean removerLivroPorNome (String nome) {
        Iterator<model.Produto> iterator = CadastroDeLivros.getListaLivros().iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            model.Produto produto = iterator.next();
            if (produto.getNomeDoLivro().equalsIgnoreCase(nome)) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }


    public String getLivroDelete() {
        return livroDelete;
    }
    public void setLivroDelete(String livroDelete) {
        this.livroDelete = livroDelete;
    }

}
