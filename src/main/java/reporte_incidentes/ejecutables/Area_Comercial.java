package reporte_incidentes.ejecutables;


import reporte_incidentes.clases.controlador.PersonaTecnicaControlador;

public class Area_Comercial {

	public static void main(String[] args) {
		System.out.println("Funcionalidad desde Area Comercial");
		
		PersonaTecnicaControlador persona1 = new PersonaTecnicaControlador();

		
		//------------ALTA------------------
//		persona2.crearPersonaTecnica("Jorge","Contreras","65456654","25 de Mayo 423","514-645665");
		
		

		//--------------BAJA----------------
//		persona1.eliminarPersonaTecnica(indicar numero de registro a eliminar);


		
		//-------------MODIFICACION---------	
//		persona1.modificarPersonaTecnica(5,"Miguel","Altamirano","65456654","27 de Abril 443","514-645665");


		
		//------------LECTURA---------------
		System.out.println(persona1.leerPersonaTecnica(5));
		
		//------------LISTADO---------------
//		var a = persona1.listadoPersonaTecnica();
//		System.out.println(a);
		
		
	}
}
