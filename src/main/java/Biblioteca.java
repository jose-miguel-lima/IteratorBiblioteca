import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Biblioteca implements Iterable<Livro> {

    private List<Livro> livros = new ArrayList<Livro>();

    public Biblioteca(Livro... livros) {
        this.livros = new ArrayList<Livro>(Arrays.asList(livros));
    }

    public void adicionar(Livro livro) {
        this.livros.add(livro);
    }

    @Override
    public Iterator<Livro> iterator() {
        return Collections.unmodifiableList(livros).iterator();
    }

}
