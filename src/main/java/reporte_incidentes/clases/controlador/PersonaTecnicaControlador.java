package reporte_incidentes.clases.controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaQuery;
import reporte_incidentes.clases.modelo.Cliente;
import reporte_incidentes.clases.modelo.PersonaTecnica;

public class PersonaTecnicaControlador {
	private SessionFactory sesionAbierta;	
	private Session sesion;
	
	
	public void iniciarSesion () {
		sesionAbierta= (SessionFactory) new Configuration().configure().addAnnotatedClass(PersonaTecnica.class).buildSessionFactory();
		 this.sesion = sesionAbierta.openSession();
		
	}

	
//-----------------------ALTA--------------------------	
	public String crearPersonaTecnica(String nombre, String apellido,String documento, String direccion, String telefono){
		
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().addAnnotatedClass(PersonaTecnica.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {
		PersonaTecnica persona = new PersonaTecnica();
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setNumeroDocumento(documento);
		persona.setDireccion(direccion);
		persona.setTelefono(telefono);
		
		session.beginTransaction();
		session.persist(persona);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Persona Técnica agregada satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar agregar el cliente en la base de datos";
	}
	
//-----------------BAJA-------------------
	public String eliminarPersonaTecnica(int id){
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().
				addAnnotatedClass(PersonaTecnica.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {	
		session.beginTransaction();
		PersonaTecnica persona = session.get(PersonaTecnica.class, id);
		session.remove(persona);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Cliente removido satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar eliminar el cliente en la base de datos";
	}
	
	
	//-------------------MODIFICACION----------------------
	public String modificarPersonaTecnica(int id,String nombre, String apellido,String documento, String direccion, String telefono){
		SessionFactory sessionFactory = (SessionFactory) new Configuration().configure().
				addAnnotatedClass(Cliente.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
	try {	
		session.beginTransaction();
		PersonaTecnica persona = session.get(PersonaTecnica.class, id);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setNumeroDocumento(documento);
		persona.setDireccion(direccion);
		persona.setTelefono(telefono);

		
		session.persist(persona);
		session.getTransaction().commit();
		sessionFactory.close();
		return "Cliente ID "+id+" actualizado satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar modificar el cliente en la base de datos";
	}

//---------------LEER-----------------------
	public String leerPersonaTecnica(int id){
		iniciarSesion ();
	try {	
		sesion.beginTransaction();
		PersonaTecnica persona = sesion.get(PersonaTecnica.class, id);
		
//		sesion.persist(persona);
		sesion.getTransaction().commit();
		sesionAbierta.close();
		return "Cliente ID "+id+" "+ persona.toString();
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar modificar el cliente en la base de datos";
	}

	public String listadoPersonaTecnica(){
	iniciarSesion();
	
		return "Error al intentar listar los tecnicos de la base de datos";
	}
	
	
	

}
