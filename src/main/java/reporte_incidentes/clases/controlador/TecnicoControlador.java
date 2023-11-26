package reporte_incidentes.clases.controlador;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import reporte_incidentes.clases.modelo.PersonaTecnica;
import reporte_incidentes.clases.modelo.Tecnico;

public class TecnicoControlador {
	private SessionFactory sesionAbierta;	
	private Session sesion;
	
//--------------ALTA--------------------	
	public String crearTecnico(String nombre, String apellido,String documento, String direccion, String telefono,String notificacion){
		iniciarSesion ();
	try {
		Tecnico tecnico = new Tecnico(nombre,apellido,documento,direccion,telefono,notificacion);

		sesion.beginTransaction();
		sesion.persist(tecnico);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Técnico agregado satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar agregar el técnico en la base de datos";
	}
	
//-----------------BAJA-------------------
	public String eliminarTecnico(int id){
		iniciarSesion();
	try {	
		sesion.beginTransaction();
		Tecnico tecnico = sesion.get(Tecnico.class, id);
		sesion.remove(tecnico);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Técnico removido satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar eliminar el técnico en la base de datos";
	}
		
	//-------------------MODIFICACION----------------------
	public String modificarTecnico(int id,String nombre, String apellido,String documento, String direccion, String telefono,String notificacion){
		iniciarSesion();
	try {	
		sesion.beginTransaction();
		Tecnico tecnico = sesion.get(Tecnico.class, id);
		tecnico.setNombre(nombre);
		tecnico.setApellido(apellido);
		tecnico.setNumeroDocumento(documento);
		tecnico.setDireccion(direccion);
		tecnico.setTelefono(telefono);
		tecnico.setTipoNotificacion(notificacion);
		
		
		
		
		
		
		sesion.persist(tecnico);
		sesion.getTransaction().commit();
		cerrarSesion();
		return "Técnico ID "+id+" actualizado satisfactoriamente\n-------------\n";
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return "Error al intentar modificar el técnico en la base de datos";
	}

//---------------LEER-----------------------
	public Tecnico leerTecnico(int id){
		iniciarSesion ();
	try {	
		sesion.beginTransaction();
		Tecnico tecnico = sesion.get(Tecnico.class, id);

		sesion.getTransaction().commit();
		cerrarSesion();
		return tecnico;
	} catch (Exception e) {
		e.printStackTrace();
	}	
		return null;
	}

//-----------------FILTRADO------------------
	public void fitrarTecnico(String campo, String valor){		
	iniciarSesion();
	try {
		sesion.beginTransaction();
		CriteriaBuilder cb = sesion.getCriteriaBuilder();		
		CriteriaQuery<Tecnico> cq = cb.createQuery(Tecnico.class);
		// SELECT * FROM PersonaTecnica
		Root<Tecnico> root = cq.from(Tecnico.class); 
		
		//WHERE campo = "valorBuscado"
		cq.select(root).where(cb.equal(root.get(campo), valor));
				
		List<Tecnico>tecnicos = sesion.createQuery(cq).getResultList();
		System.out.println("");
		System.out.println("------------ Listado de Técnicos---------------");
		System.out.println("");	
		for(Tecnico t:tecnicos) {
			System.out.println("ID "+t.getIdTecnico() +" --> " +t.getNombre()+ " " + t.getApellido());
		}
		System.out.println("-----------------------------------------------");	
		cerrarSesion();	
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	public void iniciarSesion () {
		sesionAbierta= (SessionFactory) new Configuration().configure().addAnnotatedClass(Tecnico.class).buildSessionFactory();
		this.sesion = sesionAbierta.openSession();
	}
	
	public void cerrarSesion () {
		sesion.close();
		sesionAbierta.close();
	}
}