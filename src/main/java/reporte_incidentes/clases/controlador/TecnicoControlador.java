package reporte_incidentes.clases.controlador;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import reporte_incidentes.clases.dao.IncidenteDAO;
import reporte_incidentes.clases.dao.TecnicoDAO;
import reporte_incidentes.clases.modelo.Incidente;
import reporte_incidentes.clases.modelo.Tecnico;

public class TecnicoControlador {
	
	 public static void MasResueltosUltimosNdias(int n) throws ParseException {
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

	        TecnicoDAO winner = new TecnicoDAO();
	        if (maxEntry == null){
	        	System.out.println("No hubo incidentes reparados en los ultimos "+ n + " dias!");
	        }
	        else {	
	        Tecnico tecnico = winner.leerTecnico(maxEntry.getKey());
	        System.out.println("El tecnico "+ tecnico.getNombre() + " "+tecnico.getApellido() + " " +
	        					"tiene " + maxEntry.getValue() + " incidentes resueltos y es el ganador de los últimos " + n +" dias");
	        }
			}
	    
	 private static List<Incidente> ObtenerListaUltimosNdias(int n) throws ParseException {
	    	
	    	Date finPeriodo = new Date();
	    	Date inicioPeriodo = sumarRestarHorasFecha(finPeriodo, n * (-24));
	    	
	    	IncidenteDAO incidente = new IncidenteDAO();
	    	List<Incidente> listado = incidente.fitrarIncidente2(inicioPeriodo,finPeriodo);
	    	listado.stream().forEach(e->System.out.println("Id del Incidente -> "+ e.getIdIncidente()+ " --> "+
	    			e.getFechaSolucionReal() +
	    			"-> "+ e.calularTiempoResolucion()+" hs" +" --> Tecnico Nº "+
	    			e.getTecnico().getIdTecnico() +" ( "+ e.getTecnico().getNombre() + " "+ e.getTecnico().getApellido()+" )"));
	    	return listado;
	    
	    }
	        	
	 private static Date sumarRestarHorasFecha(Date fecha, int horas){
	    	      Calendar calendar = Calendar.getInstance();
	    	      calendar.setTime(fecha); // Configuramos la fecha que se recibe
	    	      calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
	    	      return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas	
	    	 }

	 public void MasRapidoUltimosNdias(int n) throws ParseException {
		 	Tecnico tecnicoMasRapido;
		 	HashMap<Integer,Integer> hash = new HashMap<>();
	    	List<Incidente> lista = ObtenerListaUltimosNdias(n);
	    	
	    	Optional<Long> menorTiempo = lista.stream().map(e -> e.calularTiempoResolucion()).max(Comparator.comparing(v-> v));
	    	 Long menor = menorTiempo.get();
	    	
	//HashMap almacenando tecnico y cantidad de incidentes solucionados en los n dias.     	
	    	for (Incidente i : lista) {
	    		if (i.calularTiempoResolucion()== menor) {
	    			System.out.println("\n");
	    			System.out.println("Técnico más rápido en los últimos "+n+  " resolviendo incidentes fue: "+
	    								i.getTecnico().getNombre() +" "+i.getTecnico().getApellido() +"\n" +
	    								"Fue en el incidente N° "+ i.getIdIncidente()+" y tardo "+ menor+" hs."  );
	    			return;
	    			
	    		}
	    			
	    		
	    		}
			}
	
}
