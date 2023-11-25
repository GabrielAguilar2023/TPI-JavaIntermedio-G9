package reporte_incidentes.ejecutables;

import reporte_incidentes.clases.controlador.ClienteControlador;

public class Area_Comercial {

	public static void main(String[] args) {
		System.out.println("Funcionalidad desde Area Comercial");
		
		ClienteControlador cliente1 = new ClienteControlador();
		System.out.println( cliente1.crearCliente("Bomberos Voluntarios", "Belgrano 3253", "453534656"));

		
	}
}
