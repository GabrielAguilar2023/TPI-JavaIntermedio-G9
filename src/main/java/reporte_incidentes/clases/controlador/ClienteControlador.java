package reporte_incidentes.clases.controlador;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.criteria.CriteriaQuery;

import reporte_incidentes.clases.modelo.Cliente;
import reporte_incidentes.clases.modelo.PersonaCliente;
import reporte_incidentes.clases.modelo.ServicioContratado;


public class ClienteControlador {
	
	public String CrearCliente(){
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {
		Cliente cliente = new Cliente();
		session.beginTransaction();
		session.persist(cliente);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Cliente agregado satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar agregar el cliente en la base de datos";
	}
	
	public String EliminarCliente(int id){
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().
				addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {	
		session.beginTransaction();
		Cliente cliente = session.get(Cliente.class, id);
		session.remove(cliente);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Cliente removido satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar eliminar el cliente en la base de datos";
	}
	
	public String ModificarCliente(PersonaCliente p,List<ServicioContratado>s,int id){
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().
				addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {	
		session.beginTransaction();
		Cliente cliente = session.get(Cliente.class, id);
//		cliente.setPersonaCliente(p);
//		cliente.setServicioContratado(s);
		
		session.persist(cliente);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Cliente ID "+id+" actualizado satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar modificar el cliente en la base de datos";
	}

	public String LeerCliente(int id){
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().
				addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {	
		session.beginTransaction();
		Cliente cliente = session.get(Cliente.class, id);
		
		
		session.persist(cliente);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Cliente ID "+id+" "+ cliente.toString();
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar modificar el cliente en la base de datos";
	}

	public String listadoCliente(){
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().
				addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {	
		session.beginTransaction();
		CriteriaQuery<Cliente> cq = session.getCriteriaBuilder().createQuery(Cliente.class);
		
		List<Cliente>listadoClientes = session.createQuery(cq).getResultList();
		
		System.out.println("");
		System.out.println("------------ Lista de Clientes --------------");
		for (Cliente c : listadoClientes)
		System.out.println(c.toString());	
		sessionFactory.close();
		return "------------------------------ ";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar modificar el cliente en la base de datos";
	}

}
