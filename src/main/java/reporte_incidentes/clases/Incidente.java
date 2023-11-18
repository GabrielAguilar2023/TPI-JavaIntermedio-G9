package reporte_incidentes.clases;

import java.util.Date;

import lombok.*;

@Getter @Setter
public class Incidente {
	private int incidente;
	private String nombre;
	private String descripcion;
	private Date fecha_de_apertura;
	private Date fecha_de_cierre;
	private String resolucion;
	private String maxTiempoRes;
}
