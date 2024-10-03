package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Produto;


public class CadastroDeLivros extends Produto {
    
    private String nomeLivro;
    private String nomeAutor;
    private String nomeEitora;
    private String dataPublicacao;
    private double valorLivro;
    private int estoqueLivro;
    private String continuar;
    private String confirma;

    CadastroDePessoas cadasroDePessoas = new CadastroDePessoas(null, null, 0, null);

     public CadastroDeLivros(String nomeDoLivro,String nomeDoAutor, String nomeDaEditora, String dataDaPublicacao, double valorDoLivro, int estoqueDoLivro) {
        super(nomeDoLivro, nomeDoAutor, nomeDaEditora, dataDaPublicacao, valorDoLivro, estoqueDoLivro);
    }

    // Lista de livros
     private static List<model.Produto> listaLivros = new ArrayList<>();

     // Método para cadastrar um Livro

    public void CadastroLivro(){

        Scanner scanner = new Scanner(System.in);
        int contador = 0;
        setContinuar("s");
        setConfirma("");
        

        while (!temAutor()) {
            if (contador == 0) {
                System.out.println();
                System.out.println("Ainda não há Autores cadastrados!");
                System.out.println("Cadastre um Autor primeiro...");
                cadasroDePessoas.cadastroCliente();
                System.out.println();
                contador ++;
                
            } else {
                System.out.println("Você cadastrou um CLIENTE!\nO tipo deve ser Autor\n");
                System.out.println("Cadastre um Autor primeiro...");
                cadasroDePessoas.cadastroCliente();;
                System.out.println();
            }
            
        }

        while (getContinuar().equalsIgnoreCase("s")){

        System.out.println();
        System.out.print("Nome do Livro: ");
        setNomeLivro(scanner.nextLine());
        System.out.println();
        System.out.print("Nome do Autor... ");
       
        setNomeAutor("");
        boolean autorValido = false;
        List<String> listaDeAutores = ListarMetodos.listaAutor();

        while (!autorValido) {
        System.out.print( "Nome do Autor: ");
        setNomeAutor(scanner.nextLine());
        if (listaDeAutores.contains(getNomeAutor())) {
            autorValido = true;  // Se o autor estiver na lista, a validação passa
        } else {
            System.out.println();
            System.out.println("O Autor " + getNomeAutor() + " não faz parte da lista. Tente novamente.");
        }
    }


        setNomeEitora("");
        boolean editoraValida = false;
        System.out.println();
        System.out.println("Nome da Editora... ");
        List<String> listaDeEditora = ListarMetodos.listaEditoras();;

        System.out.println();
        ListarMetodos.listaEditora();

        while (!editoraValida) {
        System.out.print( "Nome da Editora: ");
        setNomeEitora(scanner.nextLine());
      
        if (listaDeEditora.contains(getNomeEitora())) {
            editoraValida = true;  // Se a Editora estiver na lista, a validação passa
        } else {
            System.out.println();
            System.out.println("A Editora " + getNomeEitora() + " não faz parte da lista. Tente novamente.");
        }
        }
       
        System.out.print("Data da Publicação: ");
        setDataPublicacao(scanner.nextLine());
        System.out.print("Valor do Livro: R$ ");
        setValorLivro(scanner.nextDouble());
        System.out.print("Quantidade em Estoque: ");
        setEstoqueLivro(scanner.nextInt());
        scanner.nextLine();

        // Criar novo Livro

        CadastroDeLivros livro = new CadastroDeLivros(getNomeLivro(), getNomeAutor(), getNomeEitora(), getDataPublicacao(), getValorLivro(), getEstoqueLivro());

        // Adicionar livro a lista

        listaLivros.add(livro);

        System.out.println();
        System.out.println("Livro " + getNomeLivro() + " cadastrado com sucesso!");

        while (!getConfirma().equalsIgnoreCase("s") && !getConfirma().equalsIgnoreCase("n")) {
            System.out.println();
            System.out.print("Deseja cadastrar outro Livro [s/n]?: ");
            setConfirma(scanner.nextLine().trim());
    
            if (getConfirma().equalsIgnoreCase("s")) {
                setContinuar("s");
                // System.out.println();
            }
    
             else if (getConfirma().equalsIgnoreCase("n")) {
                setContinuar("n"); 
                // System.out.println();
                Scanner scannerReset = new Scanner(System.in);
            }    
            else {
                System.out.println("Opção inválida. Tente novamente!");
            }
        }
        setConfirma("");
    }
}


    // public static void listaLivro(){
        
    // }

    // Método para verificar se existe pelo menos um autor na lista
    private static boolean temAutor() {
        for (model.Pessoa pessoa : CadastroDePessoas.getListaPessoas()) {
            if (pessoa.getTipo().equals("Autor")) {
                return true;
            }
        }
        return false;
    }

    public static List<model.Produto> getListaLivros() {
        return listaLivros;
    }

    public static void setListaLivros(List<model.Produto> listaLivros) {
        CadastroDeLivros.listaLivros = listaLivros;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }
    public String getNomeAutor() {
        return nomeAutor;
    }
    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }
    public String getNomeEitora() {
        return nomeEitora;
    }
    public void setNomeEitora(String nomeEitora) {
        this.nomeEitora = nomeEitora;
    }
    public String getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    public double getValorLivro() {
        return valorLivro;
    }
    public void setValorLivro(double valorLivro) {
        this.valorLivro = valorLivro;
    }
    public int getEstoqueLivro() {
        return estoqueLivro;
    }
    public void setEstoqueLivro(int estoqueLivro) {
        this.estoqueLivro = estoqueLivro;
    }
    public void setContinuar(String continuar) {
        this.continuar = continuar;
    }
    public String getContinuar() {
        return continuar;
    }
    public String getConfirma() {
        return confirma;
    }
    public void setConfirma(String confirma) {
        this.confirma = confirma;
    }

}
