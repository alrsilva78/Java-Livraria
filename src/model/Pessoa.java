package model;


// Classe abstract com atributos para Pessoa

public abstract class Pessoa {

    private String nomeDaPessoa;
    private String cpf;
    private int idade; 
    private String tipo;

    public Pessoa(String nomeDaPessoa, String cpf, int idade, String tipo) {
        this.nomeDaPessoa = nomeDaPessoa;
        this.cpf = cpf;
        this.idade = idade;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getNomeDaPessoa() {
        return nomeDaPessoa;
    }

    public void setNomeDaPessoa(String nomeDaPessoa) {
        this.nomeDaPessoa = nomeDaPessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    };

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

    







    

    


