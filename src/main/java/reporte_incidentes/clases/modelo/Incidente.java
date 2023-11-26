package reporte_incidentes.clases.modelo;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@ Table(name="Incidentes")
public class Incidente {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idIncidente;
	
	private Date fechaInicioTramite;	
	private String descripcionProblema;
	private Date fechaSolucionEstimada;
	private Date fechaSolucionReal;
	private String informeTecnico;
	@Column(columnDefinition = "BIT(1) NOT NULL DEFAULT FALSE")
	private boolean resuelto;

	
	@ManyToOne
	@JoinColumn(name="idTecnico")
	private Tecnico tecnico;
	
	
	@OneToMany(mappedBy = "incidente")
	private List <Problema> tipoDeProblema;
	
	@ManyToOne
	@JoinColumn(name = "idContrato")
	private Contrato servicioConProblema;
	
	//***************Metodos*****************

	public Incidente(Date fechaInicioTramite, String descripcionProblema, Date fechaSolucionEstimada,
			Date fechaSolucionReal, String informeTecnico) {
		this.fechaInicioTramite = fechaInicioTramite;
		this.descripcionProblema = descripcionProblema;
		this.fechaSolucionEstimada = fechaSolucionEstimada;
		this.fechaSolucionReal = fechaSolucionReal;
		this.informeTecnico = informeTecnico;
		
	}

	public Long calularTiempoResolucion() {
			Long diferencia = this.fechaSolucionReal.getTime() - this.fechaInicioTramite.getTime();
			TimeUnit unidad = TimeUnit.HOURS;
			return unidad.convert(diferencia,TimeUnit.MILLISECONDS);
	}

}
