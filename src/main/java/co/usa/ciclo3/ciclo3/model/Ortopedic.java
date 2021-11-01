package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Hugo Millan
 */

@Entity
@Table(name = "ortopedic")
public class Ortopedic implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** Base de datos Ortopedi - Definición del Id */
    private Integer id;
    /** Base de datos Ortopedi - Definición del Nombre*/
    private String name;
    /** Base de datos Ortopedi - Definición de la Marca */
    private String brand;
    /** Base de datos Ortopedi - Definición del Año*/
    private Integer year;
    /** Base de datos Ortopedi - Definición de la Descripción */
    private String description;

    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("ortopedics")
    /** Base de datos Categoria - Definición */
    private Categoria category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "client"})
    /** Base de datos Mensajes - Definición */
    private List<Mensaje> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "ortopedic")
    @JsonIgnoreProperties({"ortopedic", "client"})
    /** Base de datos Reservaciones - Definición */
    private List<Reservaciones> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservaciones> reservations) {
        this.reservations = reservations;
    }
}
