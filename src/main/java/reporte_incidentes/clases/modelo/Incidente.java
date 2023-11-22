package reporte_incidentes.clases.modelo;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.cfg.annotations.reflection.internal.XMLContext.Default;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@ Table(name="Incidentes")
public class Incidente {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idIncidente;
//	private Date fecha;
	private String descripcionProblema;
	

//	private Tecnico tecnico;
	private String fechaSolucion;
	
	@Column(columnDefinition = "BIT(1) NOT NULL DEFAULT FALSE")
	private boolean resuelto;
	private String informeTecnico;
	
	@OneToMany(mappedBy = "incidente")
	private List <Problema> tipoDeProblema;
	
	@ManyToOne
	@JoinColumn(name = "idContrato", nullable = false)
	private Contrato servicioConProblema;
}
