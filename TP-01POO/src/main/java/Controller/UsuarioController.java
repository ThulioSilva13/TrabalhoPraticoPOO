package Controller;

import Model.Usuario;

public class UsuarioController {
    public void addUsuario(Usuario usuario){
        usuario.save(usuario);
    }
    public void getAll(){
        Usuario usuario = new Usuario();
        usuario.getUsuario();
    }
    public void DeleteUsuario(int idUsuario){
        Usuario usuario = new Usuario();
        usuario.removeById(idUsuario);
    }
    public void Update(Usuario usuario){
        usuario.update(usuario);
    }
}
