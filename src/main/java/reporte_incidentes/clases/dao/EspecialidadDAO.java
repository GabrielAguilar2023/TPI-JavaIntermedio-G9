package reporte_incidentes.clases.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import reporte_incidentes.clases.modelo.Cliente;
import reporte_incidentes.clases.modelo.Especialidad;
import reporte_incidentes.clases.modelo.Tecnico;

public class EspecialidadDAO {
	
	private SessionFactory sesionAbierta;	
	private Session sesion;		
	
//--------------ALTA--------------------	
	public String crearEspecialidad(String nombre,Tecnico tecnico){
		iniciarSesion ();
	try {
		Especialidad especialidad = new Especialidad();
		especialidad.setNombre(nombre);
		especialidad.setTecnico(tecnico);
		
		sesion.beginTransaction();
		sesion.persist(especialidad);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Especialidad agregada satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar agregar Especialidad en la base de datos";
}
	

	public void iniciarSesion () {
		sesionAbierta= (SessionFactory) new Configuration().configure().addAnnotatedClass(Cliente.class).buildSessionFactory();
		this.sesion = sesionAbierta.openSession();
	}
	
	public void cerrarSesion () {
		sesion.close();
		sesionAbierta.close();
	}
}
