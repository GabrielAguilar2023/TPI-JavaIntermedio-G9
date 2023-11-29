package reporte_incidentes.clases.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @NoArgsConstructor
@Entity
@Table (name="Clientes")
public class Cliente {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//Hace al Id autoincremental y único
	private int idCliente;

	private String razonSocial;
	private String direccion;
	@Column(name="Telefono", length = 20)
	private String telefono;
			
	@OneToMany (mappedBy = "cliente")
	private List<Contrato> contratos;

	public Cliente(String razonSocial, String direccion, String telefono) {
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.telefono = telefono;
	}
}
