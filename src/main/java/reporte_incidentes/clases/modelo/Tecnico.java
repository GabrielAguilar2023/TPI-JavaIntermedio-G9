package reporte_incidentes.clases.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="Tecnicos")
public class Tecnico {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
 	private int idTecnico;
	
	@OneToOne(mappedBy = "tecnico")
 	private PersonaTecnica personaTecnica;
	
	@OneToMany (mappedBy = "tecnico")
	private List<Especialidad> especialidades;
	
	@OneToMany(mappedBy = "tecnico")
	List<Incidente> incidentes;
	
 	private String tipoNotificacion;
      
}
