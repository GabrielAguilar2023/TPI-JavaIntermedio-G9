package reporte_incidentes.ejecutables;

import reporte_incidentes.clases.controlador.ClienteControlador;
import reporte_incidentes.clases.modelo.Cliente;
import reporte_incidentes.clases.modelo.PersonaCliente;

public class Area_Comercial {

	public static void main(String[] args) {
		System.out.println("Funcionalidad desde Area Comercial");
		/*
		Cliente cliente1 = new Cliente();
		cliente1.setPersonaCliente(new PersonaCliente(0, // id
													"Cuartel de Bomberos", //razon social
													"Simon Bolivar 345",//direccion
													"3893-543543" // telefono
													));
		*/
		
		ClienteControlador clientetrolador = new ClienteControlador();
		System.out.println(clientetrolador.CrearCliente());
		//clientetrolador.listadoCliente();
		
	}
}
