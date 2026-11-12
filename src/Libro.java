public class Libro extends Material implements Prestable {

    private String autor;
    private String isbn;

    // Constructor
    public Libro(String id, String titulo, String autor, String isbn) {
        super(id, titulo);
        this.autor = autor;
        this.isbn = isbn;
    }

    // Getters
    public String getAutor() { return autor; }

    public String getIsbn() { return isbn; }

    // toString
    public String toString() {
        return "Libro " + super.toString() + " de " + autor + " (ISBN " + isbn + ")";
    }
}
