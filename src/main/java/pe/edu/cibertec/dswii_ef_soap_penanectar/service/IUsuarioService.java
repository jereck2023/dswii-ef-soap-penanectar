package pe.edu.cibertec.dswii_ef_soap_penanectar.service;

import pe.edu.cibertec.ws.objects.*;

public interface IUsuarioService {
    GetUsuariosResponse listarUsuarios();
    GetUsuarioResponse buscarUsuarioxId(Integer id);
    PostUsuarioResponse crearUsuario(PostUsuarioRequest request);
    PutUsuarioResponse editarUsuario(PutUsuarioRequest request);
}
