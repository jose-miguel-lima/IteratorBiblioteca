import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    void deveIterarNaOrdemDeInsercao() {
        Livro primeiro = new Livro("Dom Casmurro", true);
        Livro segundo = new Livro("Iracema", false);
        Biblioteca biblioteca = new Biblioteca(primeiro, segundo);

        Iterator<Livro> iterador = biblioteca.iterator();

        assertTrue(iterador.hasNext());
        assertSame(primeiro, iterador.next());
        assertTrue(iterador.hasNext());
        assertSame(segundo, iterador.next());
        assertFalse(iterador.hasNext());
    }

    @Test
    void deveIterarComForEach() {
        Biblioteca biblioteca = new Biblioteca(
                new Livro("Dom Casmurro", true),
                new Livro("Iracema", false)
        );
        List<String> titulos = new ArrayList<String>();
        for (Livro livro : biblioteca) {
            titulos.add(livro.getTitulo());
        }
        assertEquals(List.of("Dom Casmurro", "Iracema"), titulos);
    }

    @Test
    void naoDeveTerProximoEmBibliotecaVazia() {
        Biblioteca biblioteca = new Biblioteca();
        assertFalse(biblioteca.iterator().hasNext());
    }

    @Test
    void naoDeveRetornarProximoQuandoIteradorEsgotar() {
        try {
            Biblioteca biblioteca = new Biblioteca(new Livro("Dom Casmurro", true));
            Iterator<Livro> iterador = biblioteca.iterator();
            iterador.next();
            iterador.next();
            fail();
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }

    @Test
    void deveManterIteradoresIndependentes() {
        Livro primeiro = new Livro("Dom Casmurro", true);
        Livro segundo = new Livro("Iracema", false);
        Biblioteca biblioteca = new Biblioteca(primeiro, segundo);

        Iterator<Livro> a = biblioteca.iterator();
        Iterator<Livro> b = biblioteca.iterator();

        assertSame(primeiro, a.next());
        assertSame(segundo, a.next());
        assertSame(primeiro, b.next());   // b não é afetado pelo avanço de a
    }

    @Test
    void deveReiniciarAPercorrerAoPedirNovoIterador() {
        Biblioteca biblioteca = new Biblioteca(new Livro("Dom Casmurro", true));
        for (Livro livro : biblioteca) { }
        assertTrue(biblioteca.iterator().hasNext());
    }

    @Test
    void naoDevePermitirRemoverLivroPeloIterador() {
        Biblioteca biblioteca = new Biblioteca(new Livro("Dom Casmurro", true));
        try {
            Iterator<Livro> iterador = biblioteca.iterator();
            iterador.next();
            iterador.remove();
            fail();
        } catch (UnsupportedOperationException e) {
            assertEquals(1, Inventario.contarTotalLivrosBiblioteca(biblioteca));
        }
    }

    @Test
    void deveIncluirLivroAdicionadoNaIteracao() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionar(new Livro("Senhora", true));
        assertEquals(List.of("Senhora"), Inventario.listarTitulosBiblioteca(biblioteca));
    }

}
