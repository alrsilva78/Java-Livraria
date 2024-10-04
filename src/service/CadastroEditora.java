package service;

// Clasee para Cadastro de Editoras

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CadastroEditora extends model.Editora {

    // Constructor

    public CadastroEditora(String nomeEditora) {
        super(nomeEditora);
    }

    private String cadNomeEditora;
    private String continuar;
    private String confirma;

    private static List<model.Editora> listEditora = new ArrayList<>();

    public void cadastroEditora (){

        setContinuar("s");
        setConfirma("");

        Scanner scanner = new Scanner(System.in);


        while (continuar.equalsIgnoreCase("s")) { 
        System.out.println();
        System.out.print("Qual o nome da Editora: ");
        setCadNomeEditora(scanner.nextLine());
        CadastroEditora cadEditora = new CadastroEditora(getCadNomeEditora());
        listEditora.add(cadEditora);
        System.out.println("Editora " + getCadNomeEditora() + " cadastrada com sucesso!");
        
        while (!confirma.equalsIgnoreCase("s")&& !confirma.equalsIgnoreCase("n")) {
        System.out.println();
        System.out.print("Deseja cadastrar outra Editora [s/n]?: ");
        setConfirma(scanner.nextLine().trim());
            if (getConfirma().equalsIgnoreCase("s")) {
                setContinuar("s");
                // System.out.println();
                
            }
            else if (getConfirma().equalsIgnoreCase("n")){
                setContinuar("n");
                // System.out.println();

            } else {
                System.out.println("Opção inválida. Tente novamente!");
            }

        }

        setConfirma("");

    }
        }


    // Getters e Setters

    public String getCadNomeEditora() {
        return cadNomeEditora;
    }
    public void setCadNomeEditora(String cadNomeEditora) {
        this.cadNomeEditora = cadNomeEditora;
    }
    public static List<model.Editora> getListEditora() {
        return listEditora;
    }
    public static void setListEditora(List<model.Editora> listEditora) {
        CadastroEditora.listEditora = listEditora;
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
    public void setContinuar(String continuar) {
        this.continuar = continuar;
    }

}
