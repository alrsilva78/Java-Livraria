package service;

import java.util.Iterator;
import java.util.Scanner;
import model.Main;

public class DeleteClienteAutorLivro {

    public void deleteClienteAutor() {

        ListarMetodos.listaPessoas();

        if (CadastroDePessoas.getListaPessoas().isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            Main.main(null);
            // return; // Adicionei um return para evitar continuar após essa condição
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome para Exclusão: ");
        String nomeDelete = scanner.nextLine().trim();
        
        if (removerPessoaPorNome(nomeDelete)) {
            System.out.println("Pessoa " + nomeDelete + " excluída com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    private boolean removerPessoaPorNome(String nome) {
        Iterator<model.Pessoa> iterator = CadastroDePessoas.getListaPessoas().iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            model.Pessoa pessoa = iterator.next();
            if (pessoa.getNomeDaPessoa().equalsIgnoreCase(nome)) { // Assumindo que você tem um método getNomeDaPessoa
                iterator.remove();
                encontrado = true;
                break; // Para sair do loop após encontrar e remover
            }
        }
        return encontrado;
    }
}

