import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventario {

    public static Integer contarLivrosDisponiveisBiblioteca(Biblioteca biblioteca) {
        int quantidade = 0;
        for (Livro livro : biblioteca) {
            if (livro.isDisponivel()) {
                quantidade++;
            }
        }
        return quantidade;
    }

    public static Integer contarTotalLivrosBiblioteca(Biblioteca biblioteca) {
        int quantidade = 0;
        for (Iterator<Livro> l = biblioteca.iterator(); l.hasNext(); ) {
            quantidade++;
            l.next();
        }
        return quantidade;
    }

    public static List<String> listarTitulosBiblioteca(Biblioteca biblioteca) {
        List<String> titulos = new ArrayList<String>();
        for (Iterator<Livro> l = biblioteca.iterator(); l.hasNext(); ) {
            titulos.add(l.next().getTitulo());
        }
        return titulos;
    }

}
