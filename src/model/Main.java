package model;

import java.util.Scanner;

import interfaces.Start;
import service.CadastroDePessoas;
import service.DeleteClienteAutor;
import service.DeleteLivro;
import service.GerenciamentoDeVendas;
import service.CadastroDeLivros;
import service.ListarMetodos;

public class Main {

    public static void main(String[] args) {
  
        Start  cadastroDePessoasInterface = new CadastroDePessoas(null, null, 0, null);
        Start cadastrodeLivrosInterface = new CadastroDeLivros(null, null, null, null, 0, 0);

        cadastroDePessoasInterface.comeco();
        cadastroDePessoasInterface.seqIniciar();
        cadastrodeLivrosInterface.seqIniciar();

        GerenciamentoDeVendas gerenciamentoDeVendas = new GerenciamentoDeVendas();
        DeleteClienteAutor deleteClienteAutorLivro = new DeleteClienteAutor();
        DeleteLivro deleteLivro = new DeleteLivro();
        CadastroDePessoas cadastroDePessoas = new CadastroDePessoas(null, null, 0, null);
        CadastroDeLivros cadastroDeLivros = new CadastroDeLivros(null, null, null, null, 0, 0);

        String opcao;  

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("===================================");
            System.out.println("Sistema de Gestão de Livraria");
            System.out.println("==================================="); 
            System.out.println("Área de Cadastro");
            System.out.println("[1] -> Cadastro de Pessoas\n" +
                               "[2] -> Cadastro de Livros\n" +
                               "[3] -> Listar Pessoas Cadastradas\n" +
                               "[4] -> Listar Livros Cadastrados\n" +
                               "[5] -> Gerenciamento de Vendas\n" +
                               "[6] -> Excluir Pessoas\n" +
                               "[7] -> Excluir Livro\n" +
                               "[9] -> Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastroDePessoas.cadastroCliente();
                    break;
                case "2":
                    cadastroDeLivros.CadastroLivro();
                    break;
                case "3":
                    ListarMetodos.listaPessoas();
                    break;
                case "4":
                    ListarMetodos.listaLivros();;
                    break;
                case "5":
                    gerenciamentoDeVendas.vendaLivros();
                    break;
                case "6":
                    deleteClienteAutorLivro.deleteClienteAutor();
                    break;
                case "7":
                    deleteLivro.deleteLivro();
                    break;
                case "9":  
                    System.out.println("Encerrando o programa...");
                    break;
                case "10":
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida....tente novamente!");
                    System.out.println();
                    break;
            }
        } while (!opcao.equals("9"));  
        
        scanner.close();
    }
}

