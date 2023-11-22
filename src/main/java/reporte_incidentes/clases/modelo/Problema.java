package reporte_incidentes.clases.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "Problemas")
public class Problema {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//Hace al Id autoincremental y único
	private int idProblema;
	@Column (name= "Nombre")
	private String nombre;
	@Column (name="Tiempo")
	private int tiempo; //tiempo en horas
	
	@ManyToOne
	@JoinColumn(name = "idServicoContratado", nullable = false)
	private ServicioContratado servicioContratado;
	
	@ManyToOne
	@JoinColumn(name = "idIncidente", nullable = false)
	private Incidente incidente;

}