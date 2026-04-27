package services;

import entities.Usuario;
import java.util.List;
import java.util.ArrayList;

public class UsuarioService {   

    private List<Usuario> usuarios = new ArrayList<>();
    private int contadorId = 1;

    public Usuario cadastrar(String nome, String email, String senha) {

     Usuario usuario = new Usuario(contadorId++, nome, email, senha);

        usuarios.add(usuario);

        return usuario;

    }

    public Usuario login(String email, String senha) {

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }

        return null;

    }

}
