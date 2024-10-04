package model;

// Classe abstract com atributos para Editora

public abstract class Editora {

    private String nomeEditora;

     // Construtor

    public Editora (String nomeEditora){

        this.nomeEditora = nomeEditora;

    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }
    public String getNomeEditora() {
        return nomeEditora;
    }

}
