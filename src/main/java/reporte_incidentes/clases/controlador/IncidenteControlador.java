package reporte_incidentes.clases.controlador;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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

//-----------------FILTRADO------------------
	public void fitrarIncidente(String campo, String valor){		
		iniciarSesion();
		try {
			sesion.beginTransaction();
			CriteriaBuilder cb = sesion.getCriteriaBuilder();		
			CriteriaQuery<Incidente> cq = cb.createQuery(Incidente.class);
			// SELECT * FROM PersonaTecnica
			Root<Incidente> root = cq.from(Incidente.class); 
			
			//WHERE campo = "valorBuscado"
			cq.select(root).where(cb.equal(root.get(campo), valor));
					
			List<Incidente>lista = sesion.createQuery(cq).getResultList();
			System.out.println("");
			System.out.println("------------ Listado de Técnicos---------------");
			System.out.println("");	
			for(Incidente i:lista) {
				System.out.println(i.getIdIncidente()+" "+ i.getDescripcionProblema()+ " " + i.getTecnico().getIdTecnico()+ " " + i.getFechaInicioTramite());
			}
			System.out.println("-----------------------------------------------");	
			cerrarSesion();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
//---------FILTRADO POR INTERVALO DE FECHAS----------------------
		public List<Incidente> fitrarIncidente2(Date inicio, Date fin){		
			iniciarSesion();
			try {
				sesion.beginTransaction();
				CriteriaBuilder cb = sesion.getCriteriaBuilder();		
				CriteriaQuery<Incidente> cq = cb.createQuery(Incidente.class);
				// SELECT * FROM PersonaTecnica
				Root<Incidente> root = cq.from(Incidente.class); 
				
				//WHERE campo = "valorBuscado"
				cq.select(root).where(cb.between(root.get("fechaSolucionReal"), inicio,fin));
						
				List<Incidente>lista = sesion.createQuery(cq).getResultList();
				
				cerrarSesion();	
				return lista;
				
			} catch (Exception e) {
				e.printStackTrace();
				return null;		
			}
		}	
}
