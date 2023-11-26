package reporte_incidentes.ejecutables;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import reporte_incidentes.clases.controlador.IncidenteControlador;
import reporte_incidentes.clases.controlador.TecnicoControlador;
import reporte_incidentes.clases.modelo.Especialidad;
import reporte_incidentes.clases.modelo.Incidente;
import reporte_incidentes.clases.modelo.Tecnico;

public class RRHH 
{
    public static void main( String[] args ) throws ParseException{
    
    	System.out.println("Funcionalidad desde Recursos Humanos");
    	
  		
    		TecnicoControlador persona1 = new TecnicoControlador();
    		
    		//------------ALTA------------------
//   		persona1.crearTecnico("Yohana","Flores","43544543","Amelia Stocklin 5934","514-645665","Whatsapp");	

    		//--------------BAJA----------------
//    		persona1.eliminarTecnico(2);
  		
    		//-------------MODIFICACION---------	
//    		persona1.modificarTecnico(1,"Miguel","Altamirano","65456654","27 de Abril 443","514-645665","eMail");
    		
    		//------------LECTURA---------------

//    		Tecnico a = persona1.leerTecnico(1);
    		
//    		System.out.println(a.getNombre()+ " " );
    		
//    		a.getEspecialidades().stream().forEach(e->System.out.println( e.getNombre()));
//    		a.getIncidentes().stream().forEach(e->System.out.println( e.calularTiempoResolucion()+ " HS -> "));
    		
    		
    	//	for(Especialidad e:a.getEspecialidades()){
    	//		System.out.println(e.getNombre());
    	//	}
    		
    		
    		//------------LISTADO---------------
    		
//    		persona1.fitrarTecnico("apellido","Flores");
    		
    		
    		
    		MasResueltosUltimosNdias(130);
    			
    	
    }
    public static void MasResueltosUltimosNdias(int n) throws ParseException {
    	
    	Date finPeriodo = new Date();
    	Date inicioPeriodo = sumarRestarHorasFecha(finPeriodo, n * (-24));
    	
    	IncidenteControlador incidente = new IncidenteControlador();
    	List<Incidente> listado = incidente.fitrarIncidente2(inicioPeriodo,finPeriodo);
    	listado.stream().forEach(e->System.out.println("Id del Incidente -> "+ e.getIdIncidente()+ " --> "+
    			e.getFechaSolucionReal() +
    			"-> "+ e.calularTiempoResolucion()+" hs" +" --> Tecnico Nº "+
    			e.getTecnico().getIdTecnico() +" ( "+ e.getTecnico().getNombre() + " "+ e.getTecnico().getApellido()+" )"));
    }
    	
    public static Date sumarRestarHorasFecha(Date fecha, int horas){
    	      Calendar calendar = Calendar.getInstance();
    	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
    	      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
    	      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas	
    	 }
}
