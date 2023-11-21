package reporte_incidentes.clases.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@Table (name="ServiciosContratados")
public class ServicioContratado {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//Hace al Id autoincremental y único
	private int idServicioContratado;
	@Column (name="NombreServicio", length = 50)
	private String nombreServicio;
	
	@OneToMany(mappedBy = "servicioContratado")
	private List <Problema> incidentesCubiertos;
}
