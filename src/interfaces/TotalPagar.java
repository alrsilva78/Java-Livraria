package interfaces;

// Interface para cálculo de Total a Pagar

public interface TotalPagar {

    void pagamento ();


    default void totalPagar(double valor){
        System.out.println("Valor total a pagar = R$" + valor);

    }
}
