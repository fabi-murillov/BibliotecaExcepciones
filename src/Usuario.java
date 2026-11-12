import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public static final int MAXIMO_PRESTAMOS = 3;
    private int id;
    private String nombre;
    private List<Material> prestamos = new ArrayList<>();

    // Constructor
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters
    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public int cantidadPrestamos() { return prestamos.size(); }

    public void prestarMaterial(Material material)
            throws MaximoPrestamosException, MaterialNoDisponibleException {
        if (prestamos.size() >= MAXIMO_PRESTAMOS) {
            throw new MaximoPrestamosException(nombre + " ya tiene el máximo de " + MAXIMO_PRESTAMOS + " préstamos");
        }
        material.prestar();
        prestamos.add(material);
    }

    public void devolverMaterial(Material material) throws MaterialNoEncontradoException {
        if (!prestamos.remove(material)) {
            throw new MaterialNoEncontradoException(nombre + " no tiene prestado el material " + material.getId());
        }
        material.devolver();
    }

    // equals()
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Usuario)) return false;
        Usuario otro = (Usuario) obj;
        return this.id == otro.id;
    }

    // toString
    public String toString() {
        return "Usuario " + id + ": " + nombre + " (" + prestamos.size() + " préstamos)";
    }
}
