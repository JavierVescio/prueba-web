package dao.sectorPersonal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.HibernateUtil;
import datos.sectorPersonal.*;

public class PersonaDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	

/* 1.ABM */
	public int agregar(Persona objeto) {
		int id=0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Persona objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
	}
	
	public void eliminar(Persona objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
/* --- */
	
	
/* 2.TRAYENDO LA INFORMACION */
	//Mediante su clave primaria
	public Persona traerPersonaPorId(int idPersona) throws HibernateException {
		Persona objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Persona)session.get(Persona.class, idPersona);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Persona traerPersonaPorDni(String dni) throws HibernateException {
		Persona objeto = null ;
		try {
			iniciaOperacion();
			objeto = (Persona)session.createQuery("from Persona where dni="+dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Personal traerPersonalPorCuil(String cuil) throws HibernateException {
		Personal objeto = null;
		try {
			iniciaOperacion();
			objeto = (Personal)session.createQuery("from Personal p where cuil="+cuil).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	public Personal traerPersonalPorIdLogIn(int idLogIn) throws HibernateException {
		Personal objeto = null;
		try {
			iniciaOperacion();
			objeto = (Personal)session.createQuery("from Personal p inner join fetch p.tipoPersonal inner join fetch p.logIn where p.logIn="+idLogIn).uniqueResult();
		}
		finally{
			session.close();
		}
		return objeto;
	}
	
	
/* --- */
	
	
/* 3.OTRAS FUNCIONES */

	
/* --- */	
}

