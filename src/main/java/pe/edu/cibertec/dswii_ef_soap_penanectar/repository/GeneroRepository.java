package pe.edu.cibertec.dswii_ef_soap_penanectar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.dswii_ef_soap_penanectar.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero,Integer> {
}
