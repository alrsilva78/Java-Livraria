package interfaces;

public interface Start {
    void seqIniciar();  
    
    default void comeco() {
        System.out.println("Sequência de incío: ");
    }
}
