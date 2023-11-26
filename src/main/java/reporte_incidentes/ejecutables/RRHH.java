package reporte_incidentes.ejecutables;

import java.util.List;

import reporte_incidentes.clases.controlador.TecnicoControlador;
import reporte_incidentes.clases.modelo.Especialidad;
import reporte_incidentes.clases.modelo.Tecnico;

public class RRHH 
{
    public static void main( String[] args ){
    
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
    		
    		
    		
//    		a.getIncidentes().stream().forEach(e->System.out.println( e.calularTiempoResolucion()+ " HS "));
    		
    		
    	//	for(Especialidad e:a.getEspecialidades()){
    	//		System.out.println(e.getNombre());
    	//	}
    		
    		
    		//------------LISTADO---------------
    		
//    		persona1.fitrarTecnico("apellido","Flores");
    			
    	
    }
    	
}
