package reporte_incidentes.clases.modelo;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity @Table (name="PersonasCliente")
public class PersonaCliente {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPersonaCliente;
	private String razonSocial;
	private String direccion;
	private String telefono;
	
	@OneToOne
	@JoinColumn(name="IdCliente")
	private Cliente cliente;

	public String toString(){
		return this.razonSocial +" "+this.direccion+" "+ this.telefono +" ";
	}
}
