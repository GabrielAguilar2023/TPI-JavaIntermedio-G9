package reporte_incidentes.clases.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@Table (name="Clientes")
public class Cliente {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//Hace al Id autoincremental y único
	private int id_cliente;
		
	@OneToOne(mappedBy = "cliente")
	private PersonaCliente personaCliente;
	
	@OneToMany (mappedBy = "cliente")
	private List<Contrato> contratos;
	
public String toString() {
	
	return personaCliente.toString() + " "; // TODO Agregar listado de servicios contratados  
}
}
