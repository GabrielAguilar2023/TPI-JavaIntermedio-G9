package reporte_incidentes.clases.controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import reporte_incidentes.clases.modelo.PersonaTecnica;

public class PersonaTecnicaControlador {
	private SessionFactory sesionAbierta;	
	private Session sesion;
		

	
//--------------ALTA--------------------	
	public String crearPersonaTecnica(String nombre, String apellido,String documento, String direccion, String telefono){
		iniciarSesion ();
	try {
		PersonaTecnica persona = new PersonaTecnica(nombre,apellido,documento,direccion,telefono);

		sesion.beginTransaction();
		sesion.persist(persona);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Persona Técnica agregada satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar agregar el cliente en la base de datos";
	}
	
//-----------------BAJA-------------------
	public String eliminarPersonaTecnica(int id){
		iniciarSesion();
	try {	
		sesion.beginTransaction();
		PersonaTecnica persona = sesion.get(PersonaTecnica.class, id);
		sesion.remove(persona);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Cliente removido satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar eliminar el cliente en la base de datos";
	}
		
	//-------------------MODIFICACION----------------------
	public String modificarPersonaTecnica(int id,String nombre, String apellido,String documento, String direccion, String telefono){
		iniciarSesion();
	try {	
		sesion.beginTransaction();
		PersonaTecnica persona = sesion.get(PersonaTecnica.class, id);
		persona.setNombre(nombre);
		persona.setApellido(apellido);
		persona.setNumeroDocumento(documento);
		persona.setDireccion(direccion);
		persona.setTelefono(telefono);

		sesion.persist(persona);
		sesion.getTransaction().commit();
		cerrarSesion();
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

		sesion.getTransaction().commit();
		cerrarSesion();
		return "Cliente ID "+id+" "+ persona.toString();
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar modificar el cliente en la base de datos";
	}

//-----------------FILTRADO------------------
	public void fitrarPersonaTecnica(String campo, String valor){		
	iniciarSesion();
	try {
		sesion.beginTransaction();
		CriteriaBuilder cb = sesion.getCriteriaBuilder();		
		CriteriaQuery<PersonaTecnica> cq = cb.createQuery(PersonaTecnica.class);
		// SELECT * FROM PersonaTecnica
		Root<PersonaTecnica> root = cq.from(PersonaTecnica.class); 
		
		//WHERE campo = "valorBuscado"
		cq.select(root).where(cb.equal(root.get(campo), valor));
				
		List<PersonaTecnica>tecnicos = sesion.createQuery(cq).getResultList();
		System.out.println("");
		System.out.println("------------ Listado de Técnicos---------------");
		System.out.println("");	
		for(PersonaTecnica p:tecnicos) {
			System.out.println(p.getIdPersonaTecnica()+" "+ p.getNombre()+ " " + p.getApellido());
		}
		System.out.println("-----------------------------------------------");	
		cerrarSesion();	
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	public void iniciarSesion () {
		sesionAbierta= (SessionFactory) new Configuration().configure().addAnnotatedClass(PersonaTecnica.class).buildSessionFactory();
		this.sesion = sesionAbierta.openSession();
	}
	
	public void cerrarSesion () {
		sesion.close();
		sesionAbierta.close();
	}
}





