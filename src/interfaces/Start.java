package interfaces;

public interface Start {
    void seqIniciar() ;  
    
    default void comeco() {
        System.out.println("Sequência de início:");
        System.out.println("1 - Comece Cadastranto um Cliente");
        System.out.println("2 - Cadastre um Autor");
        System.out.println("3 - Cadastre uma Editora");
        System.out.println("4 - Cadastre um livro com estoque");
        System.out.println("5 - Realize uma compra");
    }
}
