public class Main {

    public static void main(String[] args) {

        // Biblioteca, materiales y usuarios
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.registrarMaterial(new Libro("L001", "Cien años de soledad", "Gabriel García Márquez", "978-0307474728"));
        biblioteca.registrarMaterial(new Libro("L002", "El Aleph", "Jorge Luis Borges", "978-0142437889"));
        biblioteca.registrarMaterial(new Libro("L003", "Rayuela", "Julio Cortázar", "978-8437604572"));
        biblioteca.registrarMaterial(new Revista("R001", "National Geographic", 245));
        biblioteca.registrarUsuario(new Usuario(1, "Ana"));
        biblioteca.registrarUsuario(new Usuario(2, "Luis"));

        try {
            System.out.println(biblioteca.buscarMaterial("L001"));
            System.out.println(biblioteca.buscarMaterial("R001"));
            System.out.println(biblioteca.buscarUsuario(1) + "\n");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        }

        // 1. Préstamo exitoso
        System.out.println("1. Préstamo exitoso");
        try {
            biblioteca.prestarMaterial(1, "L001");
            System.out.println("Préstamo realizado.");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operación finalizada.\n");
        }

        // 2. Material ya prestado
        System.out.println("2. Material ya prestado");
        try {
            biblioteca.prestarMaterial(2, "L001");
            System.out.println("Préstamo realizado.");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operación finalizada.\n");
        }

        // 3. Material inexistente
        System.out.println("3. Material inexistente");
        try {
            biblioteca.prestarMaterial(1, "X999");
            System.out.println("Préstamo realizado.");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operación finalizada.\n");
        }

        // 4. Usuario inexistente
        System.out.println("4. Usuario inexistente");
        try {
            biblioteca.prestarMaterial(99, "L002");
            System.out.println("Préstamo realizado.");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operación finalizada.\n");
        }

        // 5. Superar el máximo (Ana ya tiene L001; el tercer préstamo adicional falla)
        System.out.println("5. Máximo de préstamos");
        try {
            biblioteca.prestarMaterial(1, "L002");
            biblioteca.prestarMaterial(1, "R001");
            biblioteca.prestarMaterial(1, "L003");
            System.out.println("Préstamos realizados.");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operación finalizada.\n");
        }

        // Devolución
        System.out.println("Devolución");
        try {
            biblioteca.devolverMaterial(1, "L001");
            System.out.println("Devolución realizada.");
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        } finally {
            System.out.println("Operación finalizada.");
        }

        // Estado final de Ana
        try {
            System.out.println("\n" + biblioteca.buscarUsuario(1));
        } catch (BibliotecaException e) {
            System.out.println("Error: " + e.getMessage());
            RegistroErrores.registrar(e);
        }
    }
}
