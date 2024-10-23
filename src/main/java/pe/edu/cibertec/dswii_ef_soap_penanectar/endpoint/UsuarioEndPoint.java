package pe.edu.cibertec.dswii_ef_soap_penanectar.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_ef_soap_penanectar.service.IUsuarioService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class UsuarioEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IUsuarioService usuarioService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuariosRequest")
    @ResponsePayload
    public GetUsuariosResponse getUsuarios(@RequestPayload
                                           GetUsuariosRequest request){
        return usuarioService.listarUsuarios();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUsuarioRequest")
    @ResponsePayload
    public GetUsuarioResponse getUsuarioXid(
            @RequestPayload GetUsuarioRequest request){
        return usuarioService.buscarUsuarioxId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postUsuarioRequest")
    @ResponsePayload
    public PostUsuarioResponse saveUsuario(@RequestPayload
                                           PostUsuarioRequest request){
        return usuarioService.crearUsuario(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putUsuarioRequest")
    @ResponsePayload
    public PutUsuarioResponse updateUsuario(@RequestPayload
                                            PutUsuarioRequest request){
        return usuarioService.editarUsuario(request);
    }
}
