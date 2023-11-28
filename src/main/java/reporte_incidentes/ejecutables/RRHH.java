package reporte_incidentes.ejecutables;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jakarta.persistence.criteria.CriteriaBuilder.Case;
import reporte_incidentes.clases.controlador.TecnicoControlador;
import reporte_incidentes.clases.dao.IncidenteDAO;
import reporte_incidentes.clases.dao.TecnicoDAO;
import reporte_incidentes.clases.modelo.Especialidad;
import reporte_incidentes.clases.modelo.Incidente;
import reporte_incidentes.clases.modelo.Tecnico;

public class RRHH {
    public static void main( String[] args ) throws ParseException{
    
    	System.out.println("Funcionalidad desde Recursos Humanos");
    	
		TecnicoControlador ranking = new TecnicoControlador();
    		
//------------ALTA------------------
//   		persona1.crearTecnico("Yohana","Flores","43544543","Amelia Stocklin 5934","514-645665","Whatsapp");	

//--------------BAJA----------------
//    		persona1.eliminarTecnico(2);
  		
//-------------MODIFICACION---------	
//    		persona1.modificarTecnico(1,"Miguel","Altamirano","65456654","27 de Abril 443","514-645665","eMail");
    		
//------------LECTURA---------------
/*
   		Tecnico a = persona1.leerTecnico(1);
    		
    		System.out.println("----------- TECNICO --------------");
    		System.out.println(a.getNombre()+ " " +a.getApellido());
    		System.out.println("-------- Especialidades-----------");
    		a.getEspecialidades().stream().forEach(e->System.out.println( e.getNombre()));
    		System.out.println("---------Ultimos tiempos de resolucion de incidentes");
    		a.getIncidentes().stream().forEach(e->System.out.println( e.calularTiempoResolucion()+ " HS -> Incidente Nº "+e.getIdIncidente()));    		
*/    		
//------------LISTADO---------------
    		
//    		persona1.fitrarTecnico("apellido","Flores");
    		
    			System.out.println("\nElija una opcion:\n1 --> Agregar un Técnico\n"
    					+ "2 --> Quién fue el técnico que más rápido resolvió los incidentes \n"
    					+ "3 --> Quién fue el técnico con más incidentes resueltos en los últimos N días\n"
    					+ "4 --> Listado de Técnicos");
    			Scanner scanner = new Scanner(System.in);
    			int opcion = scanner.nextInt();
    			switch (opcion) {
				case 1: {
					
					break;
				}
				case 2: {
					System.out.println("Ingrese el numero de dias a contabilizar");
					ranking.MasRapidoUltimosNdias(scanner.nextInt());
					break;
				}
				case 3: {
					System.out.println("Ingrese el numero de dias a contabilizar");
					ranking.MasResueltosUltimosNdias(scanner.nextInt());
					break;
				}
				case 4: {
					ranking.listaTecnico();
					break;
				}
				default:
				System.out.println(opcion + " No es una opcion válida");
				}
    }
}
