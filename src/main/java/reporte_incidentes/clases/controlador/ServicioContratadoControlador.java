package reporte_incidentes.clases.controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import reporte_incidentes.clases.modelo.Cliente;
import reporte_incidentes.clases.modelo.PersonaCliente;
import reporte_incidentes.clases.modelo.ServicioContratado;

public class ServicioContratadoControlador {

	public String CrearServicioContratado(ServicioContratado s){
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {
		session.beginTransaction();
		session.persist(s);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Cliente agregado satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar agregar el cliente en la base de datos";
	}
	
	
}
