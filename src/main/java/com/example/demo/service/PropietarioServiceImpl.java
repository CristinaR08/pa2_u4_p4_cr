package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IPropietarioRepository;
import com.example.demo.repository.modelo.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements IPropietarioService{
	
	@Autowired
	private IPropietarioRepository propietarioRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void agregar(Propietario propietario) {
		this.propietarioRepository.insertar(propietario);
	}
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void modificar(Propietario propietario) {
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Propietario encontrar(Integer id) {
		return this.propietarioRepository.buscar(id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void borrar(Integer id) {
		this.propietarioRepository.eliminar(id);
	}


	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> buscarLista() {
		return this.propietarioRepository.buscarTodos();
	}

}
