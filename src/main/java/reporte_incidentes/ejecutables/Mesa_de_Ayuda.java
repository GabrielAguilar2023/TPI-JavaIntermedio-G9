package reporte_incidentes.ejecutables;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;

import reporte_incidentes.clases.controlador.IncidenteControlador;
import reporte_incidentes.clases.modelo.Incidente;

public class Mesa_de_Ayuda {

	public static void main(String[] args) throws ParseException {
		System.out.println("Funcionalidad desde la Mesa de Ayuda");
		
		// Crear datos de fecha
		DateFormat formateador = new SimpleDateFormat("dd/M/yy H:m:s");		
		Date fechaInicio = formateador.parse("24/10/23 22:23:10");
		Date fechaSolucionEstimada = formateador.parse("27/10/23 22:23:10");
		Date fechaSolucionReal = formateador.parse("25/10/23 22:23:10");
		
		// persistir un incidente en la base incidente
		IncidenteControlador incidente = new IncidenteControlador();
		
		
		
//		Incidente ObjIncidente = incidente.crearIncidente(fechaInicio,"Incidente 1",fechaSolucionEstimada,fechaSolucionReal ,"Todo termino OK");		
		Incidente ObjIncidente = incidente.leerIncidente(1);	
		
		
		System.out.println(	ObjIncidente.calularTiempoResolucion() + " Hs.");
	
	
	
	
	
	}

			

				
	}



























/*

DateFormat formateador = new SimpleDateFormat("dd/M/yy H:m:s");

try {
	Date fecha = formateador.parse("24/11/23 22:23:10");
	
	//Ahora
	Date ahora = new Date();

	Long tiempoTranscurrido = ahora.getTime() - fecha.getTime();
	TimeUnit unidades = TimeUnit.MINUTES;
	Long TiempoEnMinutos = unidades.convert(tiempoTranscurrido,TimeUnit.MILLISECONDS);
	
	
/*			Calendar calendario = new GregorianCalendar();
	Calendar calendario2 = new GregorianCalendar();
	
	
	
	
	calendario.setTime(fecha);
	calendario2.setTime(ahora);
*/			
	
	
/*	
	System.out.println(TiempoEnMinutos);
	
	
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
*/