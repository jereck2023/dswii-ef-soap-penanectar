package pe.edu.cibertec.dswii_ef_soap_penanectar.service;

import pe.edu.cibertec.ws.objects.*;

public interface IGeneroService {
    GetGenerosResponse listarGeneros();
    GetGeneroResponse buscarGeneroxId(Integer id);
    PostGeneroResponse crearGenero(PostGeneroRequest request);
    PutGeneroResponse editarGenero(PutGeneroRequest request);
}
