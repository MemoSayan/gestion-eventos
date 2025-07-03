package py.com.gullermo.gestion_eventos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoCiudad;

    @NotBlank
    private String descripcionCiudad;


    public Ciudad() {
    }

    public Ciudad(Long codigoCiudad, String descripcionCiudad) {
        this.codigoCiudad = codigoCiudad;
        this.descripcionCiudad = descripcionCiudad;
    }

    // --- Getters y Setters ---
    public Long getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(Long codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getDescripcionCiudad() {
        return descripcionCiudad;
    }

    public void setDescripcionCiudad(String descripcionCiudad) {
        this.descripcionCiudad = descripcionCiudad;
    }


    @Override
    public String toString() {
        return "Ciudad{" +
                "codigoCiudad=" + codigoCiudad +
                ", descripcionCiudad='" + descripcionCiudad + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(codigoCiudad, ciudad.codigoCiudad)
                && Objects.equals(descripcionCiudad, ciudad.descripcionCiudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCiudad, descripcionCiudad);
    }
}