package reporte_incidentes.clases;

import lombok.*;

@Getter @Setter
public class Cliente {
	private int id_cliente;
	private String nombre; 
	private String apellido;
	private String email;
	private String cuit;
	private String razon_Social;
	
}
