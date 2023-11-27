package reporte_incidentes.ejecutables;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reporte_incidentes.clases.controlador.IncidenteControlador;
import reporte_incidentes.clases.controlador.TecnicoControlador;
import reporte_incidentes.clases.modelo.Especialidad;
import reporte_incidentes.clases.modelo.Incidente;
import reporte_incidentes.clases.modelo.Tecnico;

public class RRHH {
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
    		Tecnico a = persona1.leerTecnico(1);
    		
    		System.out.println("----------- TECNICO --------------");
    		System.out.println(a.getNombre()+ " " +a.getApellido());
    		System.out.println("-------- Especialidades-----------");
    		a.getEspecialidades().stream().forEach(e->System.out.println( e.getNombre()));
    		System.out.println("---------Ultimos tiempos de resolucion de incidentes");
    		a.getIncidentes().stream().forEach(e->System.out.println( e.calularTiempoResolucion()+ " HS -> Incidente Nº "+e.getIdIncidente()));    		
    		
//------------LISTADO---------------
    		
//    		persona1.fitrarTecnico("apellido","Flores");
    		
    		
//----------Técnico con mas incidentes resueltos en los últimos N días
//    		MasResueltosUltimosNdias(35);
    			
    }
    
    private static void MasResueltosUltimosNdias(int n) throws ParseException {
    	HashMap<Integer,Integer> hash = new HashMap<>();
    	List<Incidente> lista = ObtenerListaUltimosNdias(n);
//HashMap almacenando tecnico y cantidad de incidentes solucionados en los n dias.     	
    	for (Incidente i : lista) {
    		int tecnico = i.getTecnico().getIdTecnico();
    		if (hash.containsKey(tecnico)) {
    			int	valor = hash.get(tecnico);
    			hash.put(tecnico, valor+1);
    		}
    		else {
    			hash.put(tecnico,1);
    		}
		}
// Obtener el id del tecnico con mas incidentes solucionados     	
    	Map.Entry<Integer,Integer> maxEntry = null;
        for (Map.Entry<Integer,Integer> entry : hash.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        TecnicoControlador winner = new TecnicoControlador();
        if (maxEntry == null){
        	System.out.println("No hubo incidentes reparados en los ultimos "+ n + " dias!");
        }
        else {	
        Tecnico tecnico = winner.leerTecnico(maxEntry.getKey());
        System.out.println("El tecnico "+ tecnico.getNombre() + " "+tecnico.getApellido() + " " +
        					"tiene " + maxEntry.getValue() + " incidentes resueltos y es el ganador en estos " + n +" dias");
        }
		}
    
    public static List<Incidente> ObtenerListaUltimosNdias(int n) throws ParseException {
    	
    	Date finPeriodo = new Date();
    	Date inicioPeriodo = sumarRestarHorasFecha(finPeriodo, n * (-24));
    	
    	IncidenteControlador incidente = new IncidenteControlador();
    	List<Incidente> listado = incidente.fitrarIncidente2(inicioPeriodo,finPeriodo);
    	listado.stream().forEach(e->System.out.println("Id del Incidente -> "+ e.getIdIncidente()+ " --> "+
    			e.getFechaSolucionReal() +
    			"-> "+ e.calularTiempoResolucion()+" hs" +" --> Tecnico Nº "+
    			e.getTecnico().getIdTecnico() +" ( "+ e.getTecnico().getNombre() + " "+ e.getTecnico().getApellido()+" )"));
    	return listado;
    
    }
        	
    public static Date sumarRestarHorasFecha(Date fecha, int horas){
    	      Calendar calendar = Calendar.getInstance();
    	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
    	      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
    	      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas	
    	 }
}
