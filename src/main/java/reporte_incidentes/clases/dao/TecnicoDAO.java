package reporte_incidentes.clases.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import reporte_incidentes.clases.modelo.Tecnico;

public class TecnicoDAO {
	private SessionFactory sesionAbierta;	
	private Session sesion;
	
//--------------ALTA--------------------	
	public Tecnico crearTecnico(String nombre, String apellido,String documento, String direccion, String telefono,String notificacion){
		iniciarSesion ();
	try {
		Tecnico tecnico = new Tecnico(nombre,apellido,documento,direccion,telefono,notificacion);
		sesion.beginTransaction();
		sesion.persist(tecnico);
		sesion.getTransaction().commit();
	
		cerrarSesion();
		System.out.println( "Técnico agregado satisfactoriamente\n-------------\n");
		return tecnico;
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println( "Error al intentar agregar el técnico en la base de datos");
		return null;
	}		
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
	public List<Tecnico> fitrarTecnico(String campo, String valor){		
	iniciarSesion();
	try {
		sesion.beginTransaction();
		CriteriaBuilder cb = sesion.getCriteriaBuilder();		
		CriteriaQuery<Tecnico> cq = cb.createQuery(Tecnico.class);
		// SELECT * FROM PersonaTecnica
		Root<Tecnico> root = cq.from(Tecnico.class); 
		
		
		if (!campo.isEmpty()&&!valor.isEmpty()){
		//WHERE campo = "valorBuscado"
		cq.select(root).where(cb.equal(root.get(campo), valor));
		}		
				
		List<Tecnico>tecnicos = sesion.createQuery(cq).getResultList();
		
		cerrarSesion();	
		return tecnicos;
		
	} catch (Exception e) {
		
		System.out.println("Valor = '" + valor + "' NO ENCONTRADO en la columna '"+campo+"' de la tabla Técnicos");
		return null;
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