package pe.edu.cibertec.dswii_ef_soap_penanectar.service;

import pe.edu.cibertec.ws.objects.*;

public interface IContenidoService {
    GetContenidosResponse listarContenidos();
    GetContenidoResponse buscarContenidoxId(Integer id);
    PostContenidoResponse crearContenido(PostContenidoRequest request);
    PutContenidoResponse editarContenido(PutContenidoRequest request);
}
