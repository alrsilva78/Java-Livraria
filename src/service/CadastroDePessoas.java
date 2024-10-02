package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CadastroDePessoas extends model.Pessoa {

    // Construtor
    public CadastroDePessoas(String nomeDaPessoa, String cpf, int idade, String tipo) {
        super(nomeDaPessoa, cpf, idade, tipo);
    }

    private String continuar;
    private String confirma;
    private String option;
    private String cadNome;
    private String cadCpf;
    private int cadIdade;
    private String cadTipo;

    // Lista de pessoas
    private static List<model.Pessoa> listaPessoas = new ArrayList<>();

    // Método para cadastrar um cliente
    public void cadastroCliente() {

        Scanner scanner = new Scanner(System.in);
        setOption("");
        setContinuar("s");
        setConfirma("");
        setOption("");

        System.out.println();

        while (getContinuar().equalsIgnoreCase("s")) {

        System.out.print("Nome da Pessoa: ");
        setCadNome(scanner.nextLine());
        System.out.print("CPF da Pessoa: ");
        setCadCpf(scanner.nextLine());
        System.out.print("Qual a idade: ");
        setCadIdade(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Tipo de Cadastro [1] -> Cliente / [2] -> Autor: ");
        setOption(scanner.nextLine());
        while (!getOption().equals("1") && !getOption().equals("2")) {
            System.out.println();
            System.out.println("Opção inválida! Tente novamente!");
            System.out.println();
            System.out.print("Tipo de Cadastro [1] -> Cliente / [2] -> Autor: ");
            setOption(scanner.nextLine());      
        }
        if (getOption().equals("1")) {
            setCadTipo("Cliente");  
        }
        else if (getOption().equals("2")) {
            setCadTipo("Autor");

        } 

        // Criar novo cliente
        CadastroDePessoas cliente = new CadastroDePessoas(getCadNome(), getCadCpf(), getCadIdade(), getCadTipo());

        // Adicionar o cliente à lista
        listaPessoas.add(cliente);
        System.out.println();
        System.out.println(getCadTipo() + " " + getCadNome() + " cadastrado com sucesso!");
        System.out.println();

        while (!getConfirma().equalsIgnoreCase("s")&& !getConfirma().equalsIgnoreCase("n")) {
        System.out.println();
        System.out.print("Deseja cadastrar outra Pessoa [s/n]?: ");
        setConfirma(scanner.nextLine().trim());

        if (getConfirma().equalsIgnoreCase("s")) {
            setContinuar("s");
            System.out.println();}

         else if (getConfirma().equalsIgnoreCase("n")) {
            setContinuar("n"); 
            System.out.println();
            Scanner scannerReset = new Scanner(System.in);
        
        }    
        else {
            System.out.println("Opção inválida. Tente novamente!");
        }
       
    }
        setConfirma("");
        
    }
}

    public static List<model.Pessoa> getListaPessoas() {
        return listaPessoas;
    }
    public static void setListaPessoas(List<model.Pessoa> listaPessoas) {
        CadastroDePessoas.listaPessoas = listaPessoas;
    }

    public String getContinuar() {
        return continuar;
    }
    public void setContinuar(String continuar) {
        this.continuar = continuar;
    }
    public String getOption() {
        return option;
    }
    public void setOption(String option) {
        this.option = option;
    }

    public String getConfirma() {
        return confirma;
    }

    public void setConfirma(String confirma) {
        this.confirma = confirma;
    }

    public String getCadTipo() {
        return cadTipo;
    }

    public void setCadTipo(String cadTipo) {
        this.cadTipo = cadTipo;
    }
    public int getCadIdade() {
        return cadIdade;
    }
    public void setCadIdade(int cadIdade) {
        this.cadIdade = cadIdade;
    }
    public String getCadCpf() {
        return cadCpf;
    }
    public void setCadCpf(String cadCpf) {
        this.cadCpf = cadCpf;
    }
    public String getCadNome() {
        return cadNome;
    }
    public void setCadNome(String cadNome) {
        this.cadNome = cadNome;
    }
}






    




