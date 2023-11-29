package reporte_incidentes.ejecutables;

import reporte_incidentes.clases.dao.ClienteDAO;

public class Area_Comercial {

	public static void main(String[] args) {
		System.out.println("Funcionalidad desde Area Comercial");
		
		ClienteDAO cliente1 = new ClienteDAO();
		System.out.println( cliente1.crearCliente("Libreria 'La Esquina'", "Bedoya 895", "45353456"));	
	}
}
