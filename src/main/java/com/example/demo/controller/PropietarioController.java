package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")//en pluoral puor buoena practica
public class PropietarioController {
	
	@Autowired
	private IPropietarioService propietarioService;
	
	@GetMapping("/buscar")
	public String buscarTodos(Model modelo) {
		List<Propietario> lista = this.propietarioService.buscarLista();
		modelo.addAttribute("propietarios",lista);
		return "vistaListaPropietarios";
	}
}
