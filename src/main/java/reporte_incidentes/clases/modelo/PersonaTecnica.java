package reporte_incidentes.clases.modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="PersonasTecnicas")
public class PersonaTecnica {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPersonaTecnica;
	private String nombre;
	private String apellido;
	private	String numeroDocumento;
	private String direccion;
	private String telefono;
	
	@OneToOne
	@JoinColumn(name="idTecnico")
	private Tecnico tecnico;
	
}
