package reporte_incidentes.clases.controlador;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.criteria.Root;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import reporte_incidentes.clases.modelo.Cliente;

public class ClienteControlador {
	
	private SessionFactory sesionAbierta;	
	private Session sesion;
		
	
//--------------ALTA--------------------	
	public String crearCliente(String razonSocial,String direccion, String telefono){
		iniciarSesion ();
	try {
		Cliente cliente = new Cliente(razonSocial,direccion,telefono);

		sesion.beginTransaction();
		sesion.persist(cliente);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Persona Técnica agregada satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar agregar el cliente en la base de datos";
	}
	
//-----------------BAJA-------------------
	public String eliminarCliente(int id){
		iniciarSesion();
	try {	
		sesion.beginTransaction();
		Cliente cliente = sesion.get(Cliente.class, id);
		sesion.remove(cliente);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Cliente removido satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar eliminar el cliente en la base de datos";
	}
		
	//-------------------MODIFICACION----------------------
	public String modificarCliente(int id,String nombre, String apellido,String documento, String direccion, String telefono){
		iniciarSesion();
	try {	
		sesion.beginTransaction();
		Cliente cliente = sesion.get(Cliente.class, id);
		cliente.setRazonSocial(nombre);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		

		sesion.persist(cliente);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Cliente ID "+id+" actualizado satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar modificar el cliente en la base de datos";
	}

//---------------LEER-----------------------
	public String leerCliente(int id){
		iniciarSesion ();
	try {
		sesion.beginTransaction();
		Cliente cliente = sesion.get(Cliente.class, id);

		sesion.getTransaction().commit();
		cerrarSesion();
		return "Cliente ID "+id+" "+ cliente.toString();
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
		CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
		// SELECT * FROM PersonaTecnica
		Root<Cliente> root = cq.from(Cliente.class); 
		
		//WHERE campo = "valorBuscado"
		cq.select(root).where(cb.equal(root.get(campo), valor));
				
		List<Cliente>lista = sesion.createQuery(cq).getResultList();
		System.out.println("");
		System.out.println("------------ Listado de Técnicos---------------");
		System.out.println("");	
		for(Cliente c:lista) {
			System.out.println(c.getIdCliente()+" "+ c.getRazonSocial()+ " " + c.getDireccion()+ " " + c.getTelefono());
		}
		System.out.println("-----------------------------------------------");	
		cerrarSesion();	
		
	} catch (Exception e) {
		e.printStackTrace();
	}
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

