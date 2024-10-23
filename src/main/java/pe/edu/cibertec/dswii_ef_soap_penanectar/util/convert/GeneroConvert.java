package pe.edu.cibertec.dswii_ef_soap_penanectar.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.dswii_ef_soap_penanectar.model.Genero;
import pe.edu.cibertec.ws.objects.Generows;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroConvert {
    public Genero mapToGenero(Generows generows){
        Genero genero = new Genero();
        genero.setIdgenero(generows.getIdgenero());
        genero.setGenero(generows.getGenero());
        return genero;
    }
    public Generows mapToGenerows(Genero genero){
        Generows generows = new Generows();
        generows.setIdgenero(genero.getIdgenero());
        generows.setGenero(genero.getGenero());
        return generows;
    }

    public List<Genero> mapToGeneroList(List<Generows> generowsList){
        List<Genero> generoList = new ArrayList<>();
        for (Generows generows : generowsList){
            generoList.add(mapToGenero(generows));
        }
        return generoList;
    }

    public List<Generows> mapToGenerowsList(List<Genero> generoList){
        List<Generows> generowsList = new ArrayList<>();
        for (Genero genero : generoList){
            generowsList.add(mapToGenerows(genero));
        }
        return generowsList;
    }
}
