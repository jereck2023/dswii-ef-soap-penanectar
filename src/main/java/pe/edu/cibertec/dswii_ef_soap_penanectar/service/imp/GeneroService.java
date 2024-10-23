package pe.edu.cibertec.dswii_ef_soap_penanectar.service.imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.dswii_ef_soap_penanectar.exception.NotFoundException;
import pe.edu.cibertec.dswii_ef_soap_penanectar.model.Genero;
import pe.edu.cibertec.dswii_ef_soap_penanectar.repository.GeneroRepository;
import pe.edu.cibertec.dswii_ef_soap_penanectar.service.IGeneroService;
import pe.edu.cibertec.dswii_ef_soap_penanectar.util.convert.GeneroConvert;
import pe.edu.cibertec.ws.objects.*;

@RequiredArgsConstructor
@Service
public class GeneroService implements IGeneroService {
    private final GeneroRepository generoRepository;
    private final GeneroConvert generoConvert;
    @Override
    public GetGenerosResponse listarGeneros() {
        GetGenerosResponse getGenerosResponse = new GetGenerosResponse();
        getGenerosResponse.getGeneros().addAll(
                generoConvert.mapToGenerowsList(generoRepository.findAll())
        );
        return getGenerosResponse;
    }

    @Override
    public GetGeneroResponse buscarGeneroxId(Integer id) {
        GetGeneroResponse generoResponse = new GetGeneroResponse();
        Genero genero = generoRepository.findById(id).orElse(null);
        if(genero == null){
            throw  new NotFoundException("El genero con ID "+ id+" no existe.");
        }
        generoResponse.setGenero(
                generoConvert.mapToGenerows(genero));
        return generoResponse;
    }

    @Override
    public PostGeneroResponse crearGenero(PostGeneroRequest request) {
        PostGeneroResponse postGeneroResponse = new PostGeneroResponse();
        Genero nuevoGenero = generoRepository.save(
                generoConvert.mapToGenero(request.getGenero())
        );
        postGeneroResponse.setGenero(generoConvert.mapToGenerows(nuevoGenero));
        return postGeneroResponse;
    }

    @Override
    public PutGeneroResponse editarGenero(PutGeneroRequest request) {
        PutGeneroResponse putGeneroResponse = new PutGeneroResponse();
        Genero genero = generoRepository.findById(request.getGenero().getIdgenero()).orElse(null);
        if(genero == null){
            throw  new NotFoundException("El genero con ID "+ request.getGenero().getIdgenero()+" no existe.");
        }
        Genero generoEditado = generoConvert.mapToGenero(request.getGenero());
        generoEditado.setIdgenero(genero.getIdgenero());
        Genero generoGuardado = generoRepository.save(generoEditado);
        putGeneroResponse.setGenero(generoConvert.mapToGenerows(generoGuardado));
        return putGeneroResponse;
    }
}
