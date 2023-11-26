package reporte_incidentes.clases.controlador;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import reporte_incidentes.clases.modelo.Cliente;
import reporte_incidentes.clases.modelo.Incidente;

public class IncidenteControlador {
	private SessionFactory sesionAbierta;	
	private Session sesion;
	
	//--------------ALTA--------------------	
		public Incidente crearIncidente(Date fechaInicioTramite, String descripcion,Date fechaSolucionEstimada, Date fechaSolucionReal, String informeTecnico){
			iniciarSesion ();
		try {
			Incidente incidente  = new Incidente (fechaInicioTramite,descripcion,fechaSolucionEstimada,fechaSolucionReal,informeTecnico);

			sesion.beginTransaction();
			sesion.persist(incidente);
			sesion.getTransaction().commit();
			cerrarSesion();
			return incidente;
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
			return null;
		}
		
		public void iniciarSesion () {
			sesionAbierta= (SessionFactory) new Configuration().configure().addAnnotatedClass(Incidente.class).buildSessionFactory();
			this.sesion = sesionAbierta.openSession();
		}
		
		public void cerrarSesion () {
			sesion.close();
			sesionAbierta.close();
		}
		
	//---------------LEER-----------------------
		public Incidente leerIncidente(int id){
			iniciarSesion ();
		try {
			sesion.beginTransaction();
			Incidente incidente = sesion.get(Incidente.class, id);
			sesion.getTransaction().commit();
			cerrarSesion();
			return incidente;
		} catch (Exception e) {
			e.printStackTrace();
		}	
			return null;
		}

		
		
		
		
		
		
	
}
