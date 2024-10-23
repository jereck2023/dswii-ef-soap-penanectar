package pe.edu.cibertec.dswii_ef_soap_penanectar.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_penanectar.exception.NotFoundException;
import pe.edu.cibertec.dswii_ef_soap_penanectar.model.Usuario;
import pe.edu.cibertec.dswii_ef_soap_penanectar.repository.UsuarioRepository;
import pe.edu.cibertec.dswii_ef_soap_penanectar.service.IUsuarioService;
import pe.edu.cibertec.dswii_ef_soap_penanectar.util.convert.UsuarioConvert;
import pe.edu.cibertec.ws.objects.*;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConvert usuarioConvert;
    @Override
    public GetUsuariosResponse listarUsuarios() {
        GetUsuariosResponse getUsuariosResponse = new GetUsuariosResponse();
        getUsuariosResponse.getUsuarios().addAll(
                usuarioConvert.mapToUsuariowsList(usuarioRepository.findAll())
        );
        return getUsuariosResponse;
    }

    @Override
    public GetUsuarioResponse buscarUsuarioxId(Integer id) {
        GetUsuarioResponse usuarioResponse = new GetUsuarioResponse();
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario == null){
            throw  new NotFoundException("El usuario con ID "+ id+" no existe.");
        }
        usuarioResponse.setUsuario(
                usuarioConvert.mapToUsuariows(usuario));
        return usuarioResponse;
    }

    @Override
    public PostUsuarioResponse crearUsuario(PostUsuarioRequest request) {
        PostUsuarioResponse postUsuarioResponse = new PostUsuarioResponse();
        Usuario nuevoUsuario = usuarioRepository.save(
                usuarioConvert.mapToUsuario(request.getUsuario())
        );
        postUsuarioResponse.setUsuario(usuarioConvert.mapToUsuariows(nuevoUsuario));
        return postUsuarioResponse;
    }

    @Override
    public PutUsuarioResponse editarUsuario(PutUsuarioRequest request) {
        PutUsuarioResponse putUsuarioResponse = new PutUsuarioResponse();
        Usuario usuario = usuarioRepository.findById(request.getUsuario().getIdusuario()).orElse(null);
        if(usuario == null){
            throw  new NotFoundException("El usuario con ID "+ request.getUsuario().getIdusuario()+" no existe.");
        }
        Usuario usuarioEditado = usuarioConvert.mapToUsuario(request.getUsuario());
        usuarioEditado.setIdusuario(usuario.getIdusuario());
        Usuario usuarioGuardado = usuarioRepository.save(usuarioEditado);
        putUsuarioResponse.setUsuario(usuarioConvert.mapToUsuariows(usuarioGuardado));
        return putUsuarioResponse;
    }

}
