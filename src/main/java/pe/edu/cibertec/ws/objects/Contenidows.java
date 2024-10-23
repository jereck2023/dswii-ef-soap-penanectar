//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.10.23 a las 08:00:57 AM PET 
//


package pe.edu.cibertec.ws.objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para contenidows complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="contenidows"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idcontenido" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="idtipo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idgenero" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="fecha_estreno" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="clasificacion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contenidows", propOrder = {
    "idcontenido",
    "titulo",
    "idtipo",
    "idgenero",
    "duracion",
    "fechaEstreno",
    "clasificacion"
})
public class Contenidows {

    protected int idcontenido;
    @XmlElement(required = true)
    protected String titulo;
    protected int idtipo;
    protected int idgenero;
    protected int duracion;
    @XmlElement(name = "fecha_estreno", required = true)
    protected String fechaEstreno;
    @XmlElement(required = true)
    protected String clasificacion;

    /**
     * Obtiene el valor de la propiedad idcontenido.
     * 
     */
    public int getIdcontenido() {
        return idcontenido;
    }

    /**
     * Define el valor de la propiedad idcontenido.
     * 
     */
    public void setIdcontenido(int value) {
        this.idcontenido = value;
    }

    /**
     * Obtiene el valor de la propiedad titulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Define el valor de la propiedad titulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

    /**
     * Obtiene el valor de la propiedad idtipo.
     * 
     */
    public int getIdtipo() {
        return idtipo;
    }

    /**
     * Define el valor de la propiedad idtipo.
     * 
     */
    public void setIdtipo(int value) {
        this.idtipo = value;
    }

    /**
     * Obtiene el valor de la propiedad idgenero.
     * 
     */
    public int getIdgenero() {
        return idgenero;
    }

    /**
     * Define el valor de la propiedad idgenero.
     * 
     */
    public void setIdgenero(int value) {
        this.idgenero = value;
    }

    /**
     * Obtiene el valor de la propiedad duracion.
     * 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     */
    public void setDuracion(int value) {
        this.duracion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEstreno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaEstreno() {
        return fechaEstreno;
    }

    /**
     * Define el valor de la propiedad fechaEstreno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaEstreno(String value) {
        this.fechaEstreno = value;
    }

    /**
     * Obtiene el valor de la propiedad clasificacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * Define el valor de la propiedad clasificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClasificacion(String value) {
        this.clasificacion = value;
    }

}
