package reporte_incidentes.clases.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PersonaCliente {
	private int idPersona;
	private String razonSocial;
	private String direccion;
	private String telefono;

	public String toString(){
		return this.razonSocial +" "+this.direccion+" "+ this.telefono +" ";
	}
}
