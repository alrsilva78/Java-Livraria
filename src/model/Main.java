package model;

import java.util.Scanner;

import interfaces.Start;
import service.CadastroDePessoas;
import service.CadastroEditora;
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
        CadastroEditora cadastroDeEditora = new CadastroEditora(null);

        String opcao;  

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("===================================");
            System.out.println("Sistema de Gestão de Livraria");
            System.out.println("==================================="); 
            System.out.println("Área de Cadastro");
            System.out.println("[1] -> Cadastro de Pessoas\n" +
                                "[2] -> Cadastro de Editora\n" +
                                "[3] -> Cadastro de Livros\n" +
                                "[4] -> Listar Pessoas Cadastradas\n" +
                                "[5] -> Listar Editoras Cadastradas\n" +
                                "[6] -> Listar Livros Cadastrados\n" +
                                "[7] -> Gerenciamento de Vendas\n" +
                                "[8] -> Excluir Pessoas\n" +
                                "[9] -> Excluir Livro\n" +
                                "[0] -> Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    cadastroDePessoas.cadastroCliente();
                    break;
                case "2":
                    cadastroDeEditora.cadastroEditora();
                    break;
                case "3":
                    cadastroDeLivros.CadastroLivro();
                    break;
                case "4":
                    ListarMetodos.listaPessoas();
                    break;

                case "5":
                    ListarMetodos.listaEditora();
                    break;
                case "6":
                    ListarMetodos.listaLivros();;
                    break;
                case "7":
                    gerenciamentoDeVendas.vendaLivros();
                    break;
                case "8":
                    deleteClienteAutorLivro.deleteClienteAutor();
                    break;
                case "9":
                    deleteLivro.deleteLivro();
                    break;
                case "10":  

                    
                case "0":
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida....tente novamente!");
                    System.out.println();
                    break;
            }
        } while (!opcao.equals("0"));  
        
        scanner.close();
    }
}

