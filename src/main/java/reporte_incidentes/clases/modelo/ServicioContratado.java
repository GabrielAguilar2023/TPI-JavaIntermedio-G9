package reporte_incidentes.clases.modelo;

import java.util.List;

import lombok.*;
@Getter @Setter

public class ServicioContratado {
private int idServicio;
private String nombreServicio;
private List <Problema> incidentesCubiertos;
}
