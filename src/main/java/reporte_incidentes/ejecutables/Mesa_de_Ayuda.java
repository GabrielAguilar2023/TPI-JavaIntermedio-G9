package reporte_incidentes.ejecutables;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;

import reporte_incidentes.clases.dao.IncidenteDAO;
import reporte_incidentes.clases.modelo.Incidente;

public class Mesa_de_Ayuda {

	public static void main(String[] args) throws ParseException {
		System.out.println("Funcionalidad desde la Mesa de Ayuda");
		
		// Crear datos de fecha
		DateFormat formateador = new SimpleDateFormat("dd/M/yy H:m:s");		
		Date fechaInicio = formateador.parse("27/11/23 22:23:10");
		Date fechaSolucionEstimada = formateador.parse("28/11/23 22:23:10");
		Date fechaSolucionReal = formateador.parse("28/11/23 10:23:10");
		
// persistir un incidente en la base de datos
		IncidenteDAO incidente = new IncidenteDAO();
				
		//---------Crear------
		Incidente ObjIncidente = incidente.crearIncidente(fechaInicio,"Incidente 1",fechaSolucionEstimada,fechaSolucionReal ,"Todo termino OK");		
	
		//------ Leer ------		
//		Incidente ObjIncidente = incidente.leerIncidente(1);	
				
//		System.out.println(	ObjIncidente.calularTiempoResolucion() + " Hs.");
		
	}
}