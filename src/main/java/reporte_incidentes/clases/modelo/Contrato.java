package reporte_incidentes.clases.modelo;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@Entity
@Table (name="Contratos")
public class Contrato {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)//Hace al Id autoincremental y único
	private int idContrato;
//	Cliente cliente;
	@ManyToOne
	@JoinColumn(name="idServicioContratado", nullable = false)
	ServicioContratado servicioContratado;	

}
