package pe.edu.cibertec.dswii_ef_soap_penanectar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Contenido")
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcontenido;
    private String titulo;
    private Integer idtipo;
    private Integer idgenero;
    private Integer duracion;
    private String fecha_estreno;
    private String clasificacion;
}
