package com.mycompany.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.mycompany.controleequipamentos.Equipamento;

public class EquipamentoDAO {
	
	final static Logger logger = Logger.getLogger(EquipamentoDAO.class);
	
	private static EntityManagerFactory emf;
	
	/*protected EquipamentoDAO(IDAOFactory daoFactory) {
		super(daoFactory);
	}*/
	
	public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
	
	public boolean editar(Equipamento equipamento) throws Exception {
		
		boolean retorno = false;
		EntityManager em = null;
		
		try{
			em = getEntityManager();
			em.getTransaction().begin();
			
				em.merge(equipamento);
				em.flush();

			em.getTransaction().commit();
			retorno = true;
		}catch(Exception e){
			logger.error(e, e);
			throw new Exception(e);
		}finally {
			em.close();
		}
		return retorno;
	}

	public boolean excluir(Equipamento equipamento) throws Exception {

		boolean retorno = false;
		EntityManager em = null;
		Equipamento equipamentoVO = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			
				if (!em.contains(equipamento)) {
					equipamentoVO = (Equipamento) em.merge(equipamento);
				} else {
					equipamentoVO = equipamento;
				}
				em.remove(equipamentoVO);
				em.flush();
			
			em.getTransaction().commit();

			retorno = true;
		} catch (Exception e) {
			logger.error(e, e);
			throw new Exception(e);
		} finally {
			em.close();
		}
		return retorno;

	}

	
	public boolean incluir(Equipamento equipamento) throws Exception {
	    boolean retorno = false;
	    EntityManager em = null;
	    try {
	        em = getEntityManager();
	        em.getTransaction().begin();
	        
	        em.persist(equipamento);
	        em.flush();
	        
	        em.getTransaction().commit();
	        retorno = true;
	    } catch (Exception e) {
	        if (em != null && em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        logger.error(e, e);
	        throw new Exception(e);
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	    return retorno;
	}	

	public Equipamento consultar(Equipamento equipamento) throws Exception {
		EntityManager em = null;
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c FROM ").append(Equipamento.class.getName()).append(" c ")
			.append("WHERE c.modelo = :modelo ");
		try{
			em = getEntityManager();
			TypedQuery<Equipamento> q = em.createQuery(jpql.toString(), Equipamento.class);
			q.setParameter("modelo", equipamento.getModelo());
			
			List<Equipamento> lista = (List<Equipamento>)q.getResultList();
			Equipamento canteiro = null;
			if(lista != null && !lista.isEmpty() ){
				canteiro = lista.get(0);
			}
			return canteiro;
		}catch(Exception e){
			logger.error(e, e);
			throw new Exception(e);
		}finally {
			em.close();
		}	
	}

}

