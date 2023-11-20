package reporte_incidentes.clases.modelo;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class PersonalTecnico {
	private int idPersona;
	private String nombre;
	private String apellido;
	private	String numeroDocumento;
	private String direccion;
	private String telefono;
}
