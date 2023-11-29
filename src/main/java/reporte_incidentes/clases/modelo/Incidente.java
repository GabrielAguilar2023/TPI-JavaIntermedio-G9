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
	
// Fecha en que se denuncia el incidente
	private Date fechaInicioTramite;

	private String descripcionProblema;
// Fecha estimada de resolucion informada el cliente.	
	private Date fechaSolucionEstimada;
// Fecha en que se solucionó el incidente por parte del técnico	
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
		if (resuelto) {
			Long diferencia = this.fechaSolucionReal.getTime() - this.fechaInicioTramite.getTime();
			TimeUnit unidad = TimeUnit.HOURS;
			return unidad.convert(diferencia,TimeUnit.MILLISECONDS);
		}
		return null;
	}

}
