import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Material> materiales = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public void registrarMaterial(Material material) {
        materiales.add(material);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Material buscarMaterial(String id) throws MaterialNoEncontradoException {
        for (Material m : materiales) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        throw new MaterialNoEncontradoException("No existe un material con id " + id);
    }

    public Usuario buscarUsuario(int id) throws UsuarioNoEncontradoException {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        throw new UsuarioNoEncontradoException("No existe un usuario con id " + id);
    }

    public void prestarMaterial(int usuarioId, String materialId)
            throws UsuarioNoEncontradoException,
                   MaterialNoEncontradoException,
                   MaterialNoDisponibleException,
                   MaximoPrestamosException {
        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);
        usuario.prestarMaterial(material);
    }

    public void devolverMaterial(int usuarioId, String materialId)
            throws UsuarioNoEncontradoException, MaterialNoEncontradoException {
        Usuario usuario = buscarUsuario(usuarioId);
        Material material = buscarMaterial(materialId);
        usuario.devolverMaterial(material);
    }
}
