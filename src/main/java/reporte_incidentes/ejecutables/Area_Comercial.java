package reporte_incidentes.ejecutables;


import reporte_incidentes.clases.controlador.PersonaTecnicaControlador;

public class Area_Comercial {

	public static void main(String[] args) {
		System.out.println("Funcionalidad desde Area Comercial");		
		PersonaTecnicaControlador persona1 = new PersonaTecnicaControlador();
		
		//------------ALTA------------------
		persona1.crearPersonaTecnica("Miguel","Galvan","65456654","Sol de Mayo 423","514-645665");	

		//--------------BAJA----------------
//		persona1.eliminarPersonaTecnica(id del objeto a eliminar);

		
		//-------------MODIFICACION---------	
//		persona1.modificarPersonaTecnica(5,"Miguel","Altamirano","65456654","27 de Abril 443","514-645665");


		
		//------------LECTURA---------------
//		System.out.println(persona1.leerPersonaTecnica(9));
		
		//------------LISTADO---------------
		
		persona1.fitrarPersonaTecnica("apellido","Fernandez");
			
		
	}
}
