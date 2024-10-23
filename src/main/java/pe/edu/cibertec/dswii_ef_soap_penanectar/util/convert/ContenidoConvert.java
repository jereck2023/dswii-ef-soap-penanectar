package pe.edu.cibertec.dswii_ef_soap_penanectar.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_penanectar.model.Contenido;
import pe.edu.cibertec.ws.objects.Contenidows;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContenidoConvert {
    public Contenido mapToContenido(Contenidows contenidows){
        Contenido contenido = new Contenido();
        contenido.setIdcontenido(contenidows.getIdcontenido());
        contenido.setTitulo(contenidows.getTitulo());
        contenido.setIdtipo(contenidows.getIdtipo());
        contenido.setIdgenero(contenidows.getIdgenero());
        contenido.setDuracion(contenidows.getDuracion());
        contenido.setFecha_estreno(contenidows.getFechaEstreno());
        contenido.setClasificacion(contenidows.getClasificacion());
        return contenido;
    }
    public Contenidows mapToContenidows(Contenido contenido){
        Contenidows contenidows = new Contenidows();
        contenidows.setIdcontenido(contenido.getIdcontenido());
        contenidows.setTitulo(contenido.getTitulo());
        contenidows.setIdtipo(contenido.getIdtipo());
        contenidows.setIdgenero(contenido.getIdgenero());
        contenidows.setDuracion(contenido.getDuracion());
        contenidows.setFechaEstreno(contenido.getFecha_estreno());
        contenidows.setClasificacion(contenido.getClasificacion());
        return contenidows;
    }

    public List<Contenido> mapToContenidoList(List<Contenidows> contenidowsList){
        List<Contenido> contenidoList = new ArrayList<>();
        for (Contenidows contenidows : contenidowsList){
            contenidoList.add(mapToContenido(contenidows));
        }
        return contenidoList;
    }

    public List<Contenidows> mapToContenidowsList(List<Contenido> contenidoList){
        List<Contenidows> contenidowsList = new ArrayList<>();
        for (Contenido contenido : contenidoList){
            contenidowsList.add(mapToContenidows(contenido));
        }
        return contenidowsList;
    }
}
