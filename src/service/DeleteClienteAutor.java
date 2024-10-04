package service;

// Classe para Excluir um Cliente ou Autor cadastrado.

import java.util.Iterator;
import java.util.Scanner;
import model.Main;

public class DeleteClienteAutor {

    private String nomeDelete;

    public void deleteClienteAutor() {

        ListarMetodos.listaPessoas();

        if (CadastroDePessoas.getListaPessoas().isEmpty()) {
            System.out.println();
            Main.main(null);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Nome para Exclusão: ");
        setNomeDelete(scanner.nextLine().trim());
        
        if (removerPessoaPorNome(getNomeDelete())) {
            System.out.println("Pessoa " + getNomeDelete() + " excluída com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    private boolean removerPessoaPorNome(String nome) {
        Iterator<model.Pessoa> iterator = CadastroDePessoas.getListaPessoas().iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            model.Pessoa pessoa = iterator.next();
            if (pessoa.getNomeDaPessoa().equalsIgnoreCase(nome)) { 
                iterator.remove();
                encontrado = true;
                break; 
            }
        }
        return encontrado;
    }

    public String getNomeDelete() {
        return nomeDelete;
    }
    public void setNomeDelete(String nomeDelete) {
        this.nomeDelete = nomeDelete;
    }
}

