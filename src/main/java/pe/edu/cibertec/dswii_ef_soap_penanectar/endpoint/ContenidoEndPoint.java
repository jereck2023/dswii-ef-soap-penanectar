package pe.edu.cibertec.dswii_ef_soap_penanectar.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_ef_soap_penanectar.service.IContenidoService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class ContenidoEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IContenidoService contenidoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContenidosRequest")
    @ResponsePayload
    public GetContenidosResponse getContenidos(@RequestPayload
                                           GetContenidosRequest request){
        return contenidoService.listarContenidos();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getContenidoRequest")
    @ResponsePayload
    public GetContenidoResponse getContenidoXid(
            @RequestPayload GetContenidoRequest request){
        return contenidoService.buscarContenidoxId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postContenidoRequest")
    @ResponsePayload
    public PostContenidoResponse saveContenido(@RequestPayload
                                           PostContenidoRequest request){
        return contenidoService.crearContenido(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putContenidoRequest")
    @ResponsePayload
    public PutContenidoResponse updateContenido(@RequestPayload
                                            PutContenidoRequest request){
        return contenidoService.editarContenido(request);
    }
}
