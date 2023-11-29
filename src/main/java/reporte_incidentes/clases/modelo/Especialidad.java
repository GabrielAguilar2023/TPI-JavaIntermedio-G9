package reporte_incidentes.clases.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="Especialidades")
public class Especialidad {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspecialidad;
	private String nombre;
	
	@OneToMany(mappedBy = "especialidad")
	private List<Problema> problemas;
	
	@ManyToOne (cascade = CascadeType.REMOVE)
	@JoinColumn(name="idTecnico", nullable=false)
	private Tecnico tecnico;

}
