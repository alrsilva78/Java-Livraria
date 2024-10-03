package service;

import java.util.Scanner;
import java.util.List;

public class GerenciamentoDeVendas {

    Venda vendas = new Venda();
    CadastroDeLivros cadastroDeLivros = new CadastroDeLivros(null, null, null, null, 0, 0);
    CadastroDePessoas cadastroDePessoas = new CadastroDePessoas(null, null, 0, null);

    public void vendaLivros() {

        Scanner scanner = new Scanner(System.in);
        String nomeCliente = "";
        
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Bem-vindo à área de Vendas!\n");
        System.out.println("Antes de começar, por favor se identifique: ");
        
        List<String> listaDeClientes = ListarMetodos.listaClienteVendas();
        
        if (listaDeClientes.isEmpty()) {
            System.out.println();
            System.out.println("Ainda não há Clientes cadastrados! É preciso se cadastrar primeiro!");
            cadastroDePessoas.cadastroCliente();
            return; // Saída precoce se não há clientes
        } 
        
        boolean clienteValido = false;
        while (!clienteValido) {
            System.out.println();
            System.out.print("Seu nome: ");
            nomeCliente = scanner.nextLine();
            if (listaDeClientes.contains(nomeCliente)) {
                clienteValido = true;
            } else {
                System.out.println();
                System.out.println("O Cliente não faz parte da lista. Tente novamente.");
            }
        }
    
        if (CadastroDeLivros.getListaLivros().isEmpty()) {
            System.out.println();
            System.out.println(nomeCliente + ", cadastre um livro antes de realizar a compra!");
            cadastroDeLivros.CadastroLivro();
            return; // Saída precoce se não há livros
        } 
        
        System.out.println();
        System.out.println("Qual livro deseja comprar? " + nomeCliente + ":");
        ListarMetodos.listaLivros();
        
        // Chama o método para pegar o nome do livro a ser comprado
        vendas.realizarVenda();;

       
        
    
}}
