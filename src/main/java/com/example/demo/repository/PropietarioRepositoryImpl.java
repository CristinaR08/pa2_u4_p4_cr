package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional(value = TxType.REQUIRED)
public class PropietarioRepositoryImpl implements IPropietarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Propietario propietario) {
		this.entityManager.persist(propietario);
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Propietario propietario) {
		this.entityManager.merge(propietario);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Propietario buscar(Integer id) {
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void eliminar(Integer id) {
		this.entityManager.remove(id);
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> buscarTodos() {
		TypedQuery<Propietario> myQuery = this.entityManager.createQuery("SELECT p FROM Propietario p", Propietario.class);
		return myQuery.getResultList();
	}

}
