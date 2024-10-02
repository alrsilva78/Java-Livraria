package service;

import java.util.Iterator;
import java.util.Scanner;
import model.Main;

public class DeleteEditora {

    private String editoraDelete;

    public void deleteEditora (){

        ListarMetodos.listaEditora();;

        if (CadastroEditora.getListEditora().isEmpty()){
            System.out.println();
            Main.main(null);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Nome da Editora para exclusão: ");
        setEditoraDelete(scanner.nextLine().trim());

        if (removerEditoraPorNome(getEditoraDelete())) {
            System.out.println("Editora " + getEditoraDelete() + " excluída com sucesso!");    
        }else {
            System.out.println("Editora " + getEditoraDelete() + " não encontrada.");
        }
    }

    private boolean removerEditoraPorNome (String nome) {
        Iterator<model.Editora> iterator = CadastroEditora.getListEditora().iterator();
        boolean encontrado = false;

        while (iterator.hasNext()) {
            model.Editora editora = iterator.next();
            if (editora.getNomeEditora().equalsIgnoreCase(nome)) {
                iterator.remove();
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public String getEditoraDelete() {
        return editoraDelete;
    }
    public void setEditoraDelete(String editoraDelete) {
        this.editoraDelete = editoraDelete;
    }



    }

