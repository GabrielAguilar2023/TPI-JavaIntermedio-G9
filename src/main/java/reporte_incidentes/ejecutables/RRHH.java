package reporte_incidentes.ejecutables;

import reporte_incidentes.clases.controlador.TecnicoControlador;

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
//    		System.out.println(persona1.leerTecnico(1).getNombre());
    		
    		//------------LISTADO---------------
    		
    		persona1.fitrarTecnico("apellido","Flores");
    			
    	
    }
    	
}
