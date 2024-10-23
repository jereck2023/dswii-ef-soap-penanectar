package pe.edu.cibertec.dswii_ef_soap_penanectar.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.dswii_ef_soap_penanectar.service.IGeneroService;
import pe.edu.cibertec.ws.objects.*;

@Endpoint
public class GeneroEndPoint {
    private static final String NAMESPACE_URI = "http://www.cibertec.edu.pe/ws/objects";

    @Autowired
    private IGeneroService generoService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGenerosRequest")
    @ResponsePayload
    public GetGenerosResponse getGeneros(@RequestPayload
                                           GetGenerosRequest request){
        return generoService.listarGeneros();
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGeneroRequest")
    @ResponsePayload
    public GetGeneroResponse getGeneroXid(
            @RequestPayload GetGeneroRequest request){
        return generoService.buscarGeneroxId(request.getId());
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postGeneroRequest")
    @ResponsePayload
    public PostGeneroResponse saveGenero(@RequestPayload
                                           PostGeneroRequest request){
        return generoService.crearGenero(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putGeneroRequest")
    @ResponsePayload
    public PutGeneroResponse updateGenero(@RequestPayload
                                            PutGeneroRequest request){
        return generoService.editarGenero(request);
    }
}
