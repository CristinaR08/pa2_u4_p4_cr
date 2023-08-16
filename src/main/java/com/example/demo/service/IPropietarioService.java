package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioService {
	
	public void agregar(Propietario propietario);
	public void modificar(Propietario propietario);
	public Propietario encontrar(Integer id);
	public void borrar(Integer id);
	public List<Propietario> buscarLista();
	

}
