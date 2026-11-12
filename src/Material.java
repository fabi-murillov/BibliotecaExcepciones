public abstract class Material implements Prestable {

    private String id;
    private String titulo;
    private boolean prestado;

    // Constructor
    public Material(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    // Getters
    public String getId() { return id; }

    public String getTitulo() { return titulo; }

    public boolean estaPrestado() { return prestado; }

    // Setters
    public void setPrestado(boolean prestado) { this.prestado = prestado; }

    public void prestar() throws MaterialNoDisponibleException {
        if (prestado) {
            throw new MaterialNoDisponibleException("El material \"" + titulo + "\" ya está prestado");
        }
        prestado = true;
    }

    public void devolver() {
        prestado = false;
    }

    // equals()
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Material)) return false;
        Material otro = (Material) obj;
        return this.id.equals(otro.id);
    }

    // toString
    public String toString() {
        return "[" + id + "] " + titulo;
    }
}
