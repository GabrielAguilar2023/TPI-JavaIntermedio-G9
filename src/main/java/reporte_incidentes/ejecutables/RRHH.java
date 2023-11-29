package reporte_incidentes.ejecutables;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import jakarta.persistence.criteria.CriteriaBuilder.Case;
import reporte_incidentes.clases.controlador.RRHHControlador;
import reporte_incidentes.clases.dao.IncidenteDAO;
import reporte_incidentes.clases.dao.TecnicoDAO;
import reporte_incidentes.clases.modelo.Especialidad;
import reporte_incidentes.clases.modelo.Incidente;
import reporte_incidentes.clases.modelo.Tecnico;

public class RRHH {
    public static void main( String[] args ) throws ParseException{
    
    	System.out.println("Funcionalidad desde Recursos Humanos");
    	
		RRHHControlador tecnicoRRHH = new RRHHControlador();
    		
    			System.out.println("\nElija una opcion:\n"
    					+ "1 --> Agregar un Técnico\n"
    					+ "2 --> Quién fue el técnico que más rápido resolvió los incidentes \n"
    					+ "3 --> Quién fue el técnico con más incidentes resueltos en los últimos N días\n"
    					+ "4 --> Listado de Técnicos\n"
    					+ "5 --> Mostrar datos completos de un técnico\n"
    					+ "6 --> Eliminar un técnico\n"
    					+ "7 --> Buscar");
    			
    			Scanner scanner = new Scanner(System.in);
    			int opcion = scanner.nextInt();
    			switch (opcion) {
				case 1: {
					tecnicoRRHH.altaDeTecnico();
					break;
				}
				case 2: {
					tecnicoRRHH.MasRapidoUltimosNdias();
					break;
				}
				case 3: {
					tecnicoRRHH.MasResueltosUltimosNdias();
					break;
				}
				case 4: {
					tecnicoRRHH.listaTecnico();
					break;
				}
				case 5: {
					tecnicoRRHH.unTecnico();
					break;
				}
				case 6: {
					tecnicoRRHH.eliminarTecnico();
					break;
				}
				case 7: {
					tecnicoRRHH.buscarXcampo();
					break;
				}
				default:
				System.out.println(opcion + "No es una opcion válida");
				}
    }
}
