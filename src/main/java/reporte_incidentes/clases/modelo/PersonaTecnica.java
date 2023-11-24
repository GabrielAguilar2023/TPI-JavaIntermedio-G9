package reporte_incidentes.clases.modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
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

	@Override
	public String toString() {
		return "PersonaTecnica [idPersonaTecnica=" + idPersonaTecnica + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", numeroDocumento=" + numeroDocumento + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", tecnico=" + tecnico + "]";
	}

	public PersonaTecnica(String nombre, String apellido, String numeroDocumento, String direccion, String telefono) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroDocumento = numeroDocumento;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	
}
