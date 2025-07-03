package py.com.gullermo.gestion_eventos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "Evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoEvento;

    @NotBlank
    private String descripcionEvento;

    @ManyToOne
    @JoinColumn(name = "codigoCiudad", nullable = false)
    @NotNull
    private Ciudad ciudadEvento;


    public Evento() {
    }

    public Evento(Long codigoEvento, String descripcionEvento, Ciudad ciudadEvento) {
        this.codigoEvento = codigoEvento;
        this.descripcionEvento = descripcionEvento;
        this.ciudadEvento = ciudadEvento;
    }

    // --- Getters y Setters ---
    public Long getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(Long codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public Ciudad getCiudadEvento() {
        return ciudadEvento;
    }

    public void setCiudadEvento(Ciudad ciudadEvento) {
        this.ciudadEvento = ciudadEvento;
    }


    @Override
    public String toString() {
        return "Evento{" +
                "codigoEvento=" + codigoEvento +
                ", descripcionEvento='" + descripcionEvento + '\'' +
                ", ciudadEvento=" + ciudadEvento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return Objects.equals(codigoEvento, evento.codigoEvento)
                && Objects.equals(descripcionEvento, evento.descripcionEvento)
                && Objects.equals(ciudadEvento, evento.ciudadEvento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoEvento, descripcionEvento, ciudadEvento);
    }
}