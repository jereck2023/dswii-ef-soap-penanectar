package pe.edu.cibertec.dswii_ef_soap_penanectar.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_penanectar.model.Usuario;
import pe.edu.cibertec.ws.objects.Usuariows;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioConvert {
    public Usuario mapToUsuario(Usuariows usuariows){
        Usuario usuario = new Usuario();
        usuario.setIdusuario(usuariows.getIdusuario());
        usuario.setNombre(usuariows.getNombre());
        usuario.setCorreo(usuariows.getCorreo());
        usuario.setPassword(usuariows.getPassword());
        usuario.setFecha_registro(usuariows.getFechaRegistro());
        return usuario;
    }
    public Usuariows mapToUsuariows(Usuario usuario){
        Usuariows usuariows = new Usuariows();
        usuariows.setIdusuario(usuario.getIdusuario());
        usuariows.setNombre(usuario.getNombre());
        usuariows.setCorreo(usuario.getCorreo());
        usuariows.setPassword(usuario.getPassword());
        usuariows.setFechaRegistro(usuario.getFecha_registro());
        return usuariows;
    }

    public List<Usuario> mapToUsuarioList(List<Usuariows> usuariowsList){
        List<Usuario> usuarioList = new ArrayList<>();
        for (Usuariows usuariows : usuariowsList){
            usuarioList.add(mapToUsuario(usuariows));
        }
        return usuarioList;
    }

    public List<Usuariows> mapToUsuariowsList(List<Usuario> usuarioList){
        List<Usuariows> usuariowsList = new ArrayList<>();
        for (Usuario usuario : usuarioList){
            usuariowsList.add(mapToUsuariows(usuario));
        }
        return usuariowsList;
    }
}
