package model;

public abstract class Editora {

    private String nomeEditora;


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
