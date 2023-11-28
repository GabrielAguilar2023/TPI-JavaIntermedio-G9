package reporte_incidentes.ejecutables;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reporte_incidentes.clases.controlador.TecnicoControlador;
import reporte_incidentes.clases.dao.IncidenteDAO;
import reporte_incidentes.clases.dao.TecnicoDAO;
import reporte_incidentes.clases.modelo.Especialidad;
import reporte_incidentes.clases.modelo.Incidente;
import reporte_incidentes.clases.modelo.Tecnico;

public class RRHH {
    public static void main( String[] args ) throws ParseException{
    
    	System.out.println("Funcionalidad desde Recursos Humanos");
   		TecnicoDAO persona1 = new TecnicoDAO();
    		
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
    		
    		
//----------Técnico con mas incidentes resueltos en los últimos N días

    			TecnicoControlador ranking = new TecnicoControlador();
//    			ranking.MasResueltosUltimosNdias(135);
    			
//----------Tecnico que resolvio incidente mas rapido en los ultimos N dias  
    			
//    			TecnicoControlador ranking = new TecnicoControlador();
    			ranking.MasRapidoUltimosNdias(135);
    			
    			
    }
    
}
