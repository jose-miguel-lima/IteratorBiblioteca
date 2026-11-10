import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventarioTest {

    @Test
    void deveContarLivrosDisponiveisBiblioteca() {
        Biblioteca biblioteca = new Biblioteca(
                new Livro("Dom Casmurro", true),
                new Livro("O Cortiço", true),
                new Livro("Iracema", false),
                new Livro("Senhora", true)
        );
        assertEquals(3, Inventario.contarLivrosDisponiveisBiblioteca(biblioteca));
    }

    @Test
    void deveContarTotalLivrosBiblioteca() {
        Biblioteca biblioteca = new Biblioteca(
                new Livro("Dom Casmurro", true),
                new Livro("O Cortiço", true),
                new Livro("Iracema", false),
                new Livro("Senhora", true)
        );
        assertEquals(4, Inventario.contarTotalLivrosBiblioteca(biblioteca));
    }

    @Test
    void deveContarZeroEmBibliotecaVazia() {
        Biblioteca biblioteca = new Biblioteca();
        assertEquals(0, Inventario.contarLivrosDisponiveisBiblioteca(biblioteca));
        assertEquals(0, Inventario.contarTotalLivrosBiblioteca(biblioteca));
    }

    @Test
    void deveContarLivroAdicionadoDepoisDaCriacao() {
        Biblioteca biblioteca = new Biblioteca(new Livro("Dom Casmurro", true));
        biblioteca.adicionar(new Livro("Iracema", false));
        assertEquals(2, Inventario.contarTotalLivrosBiblioteca(biblioteca));
        assertEquals(1, Inventario.contarLivrosDisponiveisBiblioteca(biblioteca));
    }

    @Test
    void deveContarLivrosDisponiveisAposMudarADisponibilidade() {
        Livro iracema = new Livro("Iracema", false);
        Biblioteca biblioteca = new Biblioteca(new Livro("Dom Casmurro", true), iracema);
        assertEquals(1, Inventario.contarLivrosDisponiveisBiblioteca(biblioteca));

        iracema.setDisponivel(true);
        assertEquals(2, Inventario.contarLivrosDisponiveisBiblioteca(biblioteca));
    }

    @Test
    void deveListarTitulosNaOrdemDeInsercao() {
        Biblioteca biblioteca = new Biblioteca(
                new Livro("Dom Casmurro", true),
                new Livro("O Cortiço", true),
                new Livro("Iracema", false)
        );
        assertEquals(List.of("Dom Casmurro", "O Cortiço", "Iracema"),
                Inventario.listarTitulosBiblioteca(biblioteca));
    }

}
