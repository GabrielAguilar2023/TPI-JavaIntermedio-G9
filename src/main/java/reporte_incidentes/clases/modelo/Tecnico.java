package reporte_incidentes.clases.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @NoArgsConstructor
@Entity
@Table(name="Tecnicos")
public class Tecnico {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
 	private int idTecnico;
	
	private String nombre;
	private String apellido;
	private	String numeroDocumento;
	private String direccion;
	private String telefono;

	@OneToMany (mappedBy = "tecnico",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Especialidad> especialidades;
	
	@OneToMany(mappedBy = "tecnico", fetch = FetchType.EAGER)
	List<Incidente> incidentes;
	
	@Column(name="TipoNotificacion")
 	private String tipoNotificacion;

	public Tecnico(String nombre, String apellido, String numeroDocumento, String direccion, String telefono,
			String tipoNotificacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroDocumento = numeroDocumento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipoNotificacion = tipoNotificacion;
	}
  
 	
}
