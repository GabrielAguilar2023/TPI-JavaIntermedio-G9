package reporte_incidentes.clases.controlador;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

import reporte_incidentes.clases.dao.EspecialidadDAO;
import reporte_incidentes.clases.dao.IncidenteDAO;
import reporte_incidentes.clases.dao.TecnicoDAO;
import reporte_incidentes.clases.modelo.Especialidad;
import reporte_incidentes.clases.modelo.Incidente;
import reporte_incidentes.clases.modelo.Tecnico;

public class RRHHControlador {
	
	private TecnicoDAO tecnicoDAO = new TecnicoDAO();
	private EspecialidadDAO especialidadDAO = new EspecialidadDAO();
	private static Scanner scan = new Scanner(System.in);
	
	 public static void MasResueltosUltimosNdias() throws ParseException {
		 
		 System.out.println("Ingrese el numero de dias a contabilizar");
			int n = scan.nextInt();
		 
		 
	    	HashMap<Integer,Integer> hash = new HashMap<>();
	    	List<Incidente> lista = ObtenerListaUltimosNdias(n);
	//HashMap almacenando tecnico y cantidad de incidentes solucionados en los n dias.     	
	    	for (Incidente i : lista) {
	    		int tecnico = i.getTecnico().getIdTecnico();
	    		if (hash.containsKey(tecnico)) {
	    			int	valor = hash.get(tecnico);
	    			hash.put(tecnico, valor + 1);
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
	        System.out.println("\n\nEl tecnico "+ tecnico.getNombre() + " "+tecnico.getApellido() + " " +
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

	 public void MasRapidoUltimosNdias() throws ParseException {
		 System.out.println("Ingrese el numero de dias a contabilizar");
			int n = scan.nextInt();
		 
		 	Tecnico tecnicoMasRapido;
		 	HashMap<Integer,Integer> hash = new HashMap<>();
	    	List<Incidente> lista = ObtenerListaUltimosNdias(n);
	    	
	    	Optional<Long> menorTiempo = lista.stream().map(e -> e.calularTiempoResolucion()).min(Comparator.comparing(v-> v));
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
	
	 public void listaTecnico() {
		 imprimirListaTecnicos(tecnicoDAO.fitrarTecnico("",""));
	 }
	 
	 private void imprimirListaTecnicos (List<Tecnico> tecnicos) {
		if (Objects.isNull(tecnicos)) return;
			System.out.println("");
			System.out.println("------------ Listado de Técnicos---------------");
			System.out.println("");	
			for(Tecnico t:tecnicos) {
				System.out.println("ID "+t.getIdTecnico() +" --> " +t.getNombre()+ " " + t.getApellido()+ "     "+ t.getDireccion() + " "+ t.getTelefono());
			}
			System.out.println("-----------------------------------------------");
	 }

	 public void unTecnico () {
		 
		System.out.println("Ingrese el ID del tecnico a eliminar");
		int n = scan.nextInt();
		Tecnico tecnico = tecnicoDAO.leerTecnico(n);
		
 		if (Objects.nonNull(tecnico)) {
 		System.out.println("\n----------- TECNICO --------------");
 		System.out.println(tecnico.getNombre()+ " " +tecnico.getApellido()+" - Doc N° "+tecnico.getNumeroDocumento()+ " - Direccion: " +tecnico.getDireccion()+ " - Telefono: " +tecnico.getTelefono());
 		System.out.println("-------- Especialidades-----------");
 		tecnico.getEspecialidades().stream().forEach(e->System.out.println( e.getNombre()));
 		System.out.println("---------Tiempos de resolucion de incidentes");
 		tecnico.getIncidentes().stream().forEach(e->System.out.println( e.calularTiempoResolucion()+ " HS -> Incidente Nº "+e.getIdIncidente()));
 		}
 		else
 			System.out.println("¡No existe un Tecnico con ese ID en la base de datos!");
	 }

	 public void altaDeTecnico() {
// Ingresa datos personales del tecnico.
		 System.out.println("Ingrese datos del tecnico separados por comas:\nnombre, apellido, documento, direccion, telefono, notificacion");
		 String datos = scan.nextLine();
		 String[] lista = datos.split(",");	 
		 Tecnico tecnico = tecnicoDAO.crearTecnico(lista[0],lista[1],lista[2],lista[3],lista[4],lista[5]);
// Ingresa especialidad del tecnico.		 
		 System.out.println("Ingrese Especialidad del Técnico: ");
		 datos = scan.nextLine(); 		 
		 especialidadDAO.crearEspecialidad(datos,tecnico);
		 System.out.println("ID tecnico --> " + tecnico.getIdTecnico());
		 
	 }

	 public void eliminarTecnico() {
		 System.out.println("Ingrese el id del técnico a eliminar");
			int id = scan.nextInt();
		 tecnicoDAO.eliminarTecnico(id);		
	}

	 public void buscarXcampo() {
		System.out.println("Ingrese campo");
			String campo = scan.next();
		System.out.println("Ingrese valor a buscar");
			String valor = scan.next();
		imprimirListaTecnicos(tecnicoDAO.fitrarTecnico(campo,valor));			
	 }
}

