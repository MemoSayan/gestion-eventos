package py.com.gullermo.gestion_eventos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @NotBlank
    private String nombrePersona;

    @NotBlank
    private String apellidoPersona;

    @NotBlank
    @Pattern(regexp = "\\d+")
    @Column(unique = true)
    private String cedulaPersona;

    private String direccionPersona;
    private String telefonoPersona;

    @ManyToOne
    @JoinColumn(name = "codigoCiudad", nullable = false)
    private Ciudad ciudadPersona;


    public Persona() {
    }

    public Persona(Long idPersona, String nombrePersona, String apellidoPersona,
                   String cedulaPersona, String direccionPersona,
                   String telefonoPersona, Ciudad ciudadPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.cedulaPersona = cedulaPersona;
        this.direccionPersona = direccionPersona;
        this.telefonoPersona = telefonoPersona;
        this.ciudadPersona = ciudadPersona;
    }


    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public Ciudad getCiudadPersona() {
        return ciudadPersona;
    }

    public void setCiudadPersona(Ciudad ciudadPersona) {
        this.ciudadPersona = ciudadPersona;
    }
    // --- toString, equals y hashCode ---
    @Override
    public String toString() {
        return "Persona{" +
                "idPersona=" + idPersona +
                ", nombrePersona='" + nombrePersona + '\'' +
                ", apellidoPersona='" + apellidoPersona + '\'' +
                ", cedulaPersona='" + cedulaPersona + '\'' +
                ", direccionPersona='" + direccionPersona + '\'' +
                ", telefonoPersona='" + telefonoPersona + '\'' +
                ", ciudadPersona=" + ciudadPersona +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(idPersona, persona.idPersona)
                && Objects.equals(nombrePersona, persona.nombrePersona)
                && Objects.equals(apellidoPersona, persona.apellidoPersona)
                && Objects.equals(cedulaPersona, persona.cedulaPersona)
                && Objects.equals(direccionPersona, persona.direccionPersona)
                && Objects.equals(telefonoPersona, persona.telefonoPersona)
                && Objects.equals(ciudadPersona, persona.ciudadPersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, nombrePersona, apellidoPersona,
                            cedulaPersona, direccionPersona,
                            telefonoPersona, ciudadPersona);
    }
}