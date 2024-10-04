package service;

// Classe dedicada a exibir uma Lista de Registros

import java.util.ArrayList;
import java.util.List;

public class ListarMetodos extends model.Pessoa{

    Venda livroVenda = new Venda();

    public ListarMetodos(String nomeDaPessoa, String cpf, int idade) {
        super(nomeDaPessoa, cpf, idade, "Cliente");
    }

    // Método para listar Pessoas cadastrados
    public static void listaPessoas() {
        if (CadastroDePessoas.getListaPessoas().isEmpty()) {
            System.out.println();
            System.out.println("Ainda não há Pessoas cadastradas!");
        } else {
            System.out.println();
            System.out.println("Lista de Pessoas cadastradas:");
            for (model.Pessoa pessoa : CadastroDePessoas.getListaPessoas()) {
                System.out.println("=======================");
                System.out.println("Nome: " + pessoa.getNomeDaPessoa());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Idade: " + pessoa.getIdade());
                System.out.println("Tipo: " + pessoa.getTipo());
                System.out.println();
            }
        }
    }

    // Método para listar e retornar autores
    public static List<String> listaAutor() {
        List<String> listaDeAutores = new ArrayList<>();
        System.out.println();
        System.out.println("Escolha um na Lista de Autores disponíveis:");
        for (model.Pessoa pessoa : CadastroDePessoas.getListaPessoas()) {
            if (pessoa.getTipo().equals("Autor")) {
                listaDeAutores.add(pessoa.getNomeDaPessoa());
                System.out.println("Nome: " + pessoa.getNomeDaPessoa()); 
            }
        }

        return listaDeAutores;  // Retorna a lista de nomes das Editoras
    }


     // Método para listar e retornar Editoras
     public static List<String> listaEditoras() {
        List<String> listaDeEditoras = new ArrayList<>();
        System.out.print("Escolha uma na Lista de Editoras disponíveis:");
       
        for (model.Editora editora : CadastroEditora.getListEditora()){
            listaDeEditoras.add(editora.getNomeEditora());
            
        }
        return listaDeEditoras;  // Retorna a lista de nomes das Editoras
        
    }


    public static List<String> listaClienteVendas() {
        List<String> listaDeClienteVendas = new ArrayList<>();
        System.out.println("Escolha um na Lista de Clientes disponíveis:");
        for (model.Pessoa pessoa : CadastroDePessoas.getListaPessoas()) {
            if (pessoa.getTipo().equals("Cliente")) {
                listaDeClienteVendas.add(pessoa.getNomeDaPessoa());
                System.out.println("Nome: " + pessoa.getNomeDaPessoa()); 
            }
        }

        return listaDeClienteVendas;  // Retorna a lista de nomes dos clientes
    }

    // Método para listar Livros cadastrados
    public static void listaLivros() {
        if (CadastroDeLivros.getListaLivros().isEmpty()) {
            System.out.println();
            System.out.println("Ainda não há Livros cadastrados!");
        } else {
            System.out.println();
            System.out.println("Lista de Livros cadastrados:");
            for (model.Produto livro : CadastroDeLivros.getListaLivros()) {
                System.out.println("=======================");
                System.out.println("Nome: " + livro.getNomeDoLivro());
                System.out.println("Autor: " + livro.getNomeDoAutor());
                System.out.println("Editora: " + livro.getNomeDaEditora());
                System.out.println("Publicação: " + livro.getDataDaPublicacao());
                System.out.println("Valor: R$" + livro.getValorDoLivro());
                System.out.println("Estoque: " + livro.getEstoqueDoLivro());
                System.out.println();
            }
        }
    }

    // Método para listar Editoras cadastradas

    public static void listaEditora (){

        if (CadastroEditora.getListEditora().isEmpty()) {
            System.out.println();
            System.out.println("Ainda não há Editoras cadastradas!");
        }else{
            System.out.println();
            System.out.println("Lista de Editoras cadastradas:");
        for (model.Editora editora : CadastroEditora.getListEditora()) {
            System.out.println("Editora: " + editora.getNomeEditora());
        }
    }
    }
}



    
