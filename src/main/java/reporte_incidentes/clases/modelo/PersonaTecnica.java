package reporte_incidentes.clases.modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity 
@Table(name="PersonasTecnicas")
public class PersonaTecnica {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idPersonaTecnica;
	
}
