public class Revista extends Material implements Prestable {

    private int numero;

    // Constructor
    public Revista(String id, String titulo, int numero) {
        super(id, titulo);
        this.numero = numero;
    }

    // Getters
    public int getNumero() { return numero; }

    // toString
    public String toString() {
        return "Revista " + super.toString() + " N.º " + numero;
    }
}
