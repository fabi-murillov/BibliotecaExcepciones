import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroErrores {

    public static final String ARCHIVO = "errores.log";
    
    public static void registrar(Exception e) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try (PrintWriter salida = new PrintWriter(new FileWriter(ARCHIVO, true))) {
            salida.println("[" + fecha + "] " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo escribir en el log: " + ex.getMessage());
        }
    }
}
