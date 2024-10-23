package pe.edu.cibertec.dswii_ef_soap_penanectar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idhistorial;
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idcontenido")
    private Contenido contenido;
    private Date fecha_visto;
    private Integer tiempo_visto_minutos;
}
