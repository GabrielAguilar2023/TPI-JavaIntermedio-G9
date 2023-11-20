package reporte_incidentes.clases.modelo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class Tecnico {
 	private int idTecnico;
 	private PersonalTecnico personalTecnico;
 	private List<Especialidad> especialidades;
 	private String tipoNotificacion;
      
}
