package ex06;

public class Livro {
    private String titulo;
    private String autor;
    private String categoria;
    private int numPaginas;
    private int ISBN;

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public int getISBN() {
        return ISBN;
    }

    public Livro(String titulo, String autor, String categoria, int numPaginas, int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.numPaginas = numPaginas;
        this.ISBN = ISBN;
    }

    public void exibirDetalhes(){
        System.out.println("****** Detalhes Livro " + titulo + " ******");
        System.out.println("Autor: "+autor);
        System.out.println("Categoria: "+categoria);
        System.out.println("Qtd de Páginas: "+numPaginas);
        System.out.println("ISBN: "+ISBN);
    }
}
