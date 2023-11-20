package reporte_incidentes.clases.modelo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Especialidad {
	private int idEspecialidad;
	private String nombre;
	private List<Problema> problemas;

}
