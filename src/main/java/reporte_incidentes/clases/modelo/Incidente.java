package reporte_incidentes.clases.modelo;

import java.util.Date;
import java.util.List;

public class Incidente {
	private int idIncidente;
	private Date fecha;
	private String descripcionProblema;
	private Contrato servicioConProblema;
	private List<Problema> tipoDeProblema;
	private Tecnico tecnico;
	private String fechaSolucion;
	private boolean resuelto;
	private String informeTecnico;
	

}
