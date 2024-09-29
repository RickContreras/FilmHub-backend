package com.udea.filmhub.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "usuario_x_contenido")
public class UsuarioXContenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_liked")
    private Boolean isLiked;
    @Column(name = "fecha_agregado")
    private LocalDate fechaAgregado;

    @Column(name = "is_view")
    private Boolean isView;

    // Relaciones

    @ManyToOne
    @JoinColumn(name = "id_contenido")
    private Contenido contenido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    // Getters, setters, constructors

}
