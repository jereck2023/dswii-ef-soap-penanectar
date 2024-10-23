package pe.edu.cibertec.dswii_ef_soap_penanectar.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_penanectar.exception.NotFoundException;
import pe.edu.cibertec.dswii_ef_soap_penanectar.model.Contenido;
import pe.edu.cibertec.dswii_ef_soap_penanectar.repository.ContenidoRepository;
import pe.edu.cibertec.dswii_ef_soap_penanectar.service.IContenidoService;
import pe.edu.cibertec.dswii_ef_soap_penanectar.util.convert.ContenidoConvert;
import pe.edu.cibertec.ws.objects.*;

@RequiredArgsConstructor
@Service
public class ContenidoService implements IContenidoService {
    private final ContenidoRepository contenidoRepository;
    private final ContenidoConvert contenidoConvert;
    @Override
    public GetContenidosResponse listarContenidos() {
        GetContenidosResponse getContenidosResponse = new GetContenidosResponse();
        getContenidosResponse.getContenidos().addAll(
                contenidoConvert.mapToContenidowsList(contenidoRepository.findAll())
        );
        return getContenidosResponse;
    }

    @Override
    public GetContenidoResponse buscarContenidoxId(Integer id) {
        GetContenidoResponse contenidoResponse = new GetContenidoResponse();
        Contenido contenido = contenidoRepository.findById(id).orElse(null);
        if(contenido == null){
            throw  new NotFoundException("El contenido con ID "+ id+" no existe.");
        }
        contenidoResponse.setContenido(
                contenidoConvert.mapToContenidows(contenido));
        return contenidoResponse;
    }

    @Override
    public PostContenidoResponse crearContenido(PostContenidoRequest request) {
        PostContenidoResponse postContenidoResponse = new PostContenidoResponse();
        Contenido nuevoContenido = contenidoRepository.save(
                contenidoConvert.mapToContenido(request.getContenido())
        );
        postContenidoResponse.setContenido(contenidoConvert.mapToContenidows(nuevoContenido));
        return postContenidoResponse;
    }

    @Override
    public PutContenidoResponse editarContenido(PutContenidoRequest request) {
        PutContenidoResponse putContenidoResponse = new PutContenidoResponse();
        Contenido contenido = contenidoRepository.findById(request.getContenido().getIdcontenido()).orElse(null);
        if(contenido == null){
            throw  new NotFoundException("El contenido con ID "+ request.getContenido().getIdcontenido()+" no existe.");
        }
        Contenido contenidoEditado = contenidoConvert.mapToContenido(request.getContenido());
        contenidoEditado.setIdcontenido(contenido.getIdcontenido());
        Contenido contenidoGuardado = contenidoRepository.save(contenidoEditado);
        putContenidoResponse.setContenido(contenidoConvert.mapToContenidows(contenidoGuardado));
        return putContenidoResponse;
    }
}
