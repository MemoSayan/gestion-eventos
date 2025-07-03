package py.com.gullermo.gestion_eventos.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Asistencia")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsistencia;

    @ManyToOne
    @JoinColumn(name = "codigoEvento", nullable = false)
    @NotNull
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "idPersona", nullable = false)
    @NotNull
    private Persona persona;

    @NotNull
    private Boolean asistir;

    public Long getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Boolean getAsistir() {
        return asistir;
    }

    public void setAsistir(Boolean asistir) {
        this.asistir = asistir;
    }
}