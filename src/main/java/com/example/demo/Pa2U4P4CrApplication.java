package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@SpringBootApplication
public class Pa2U4P4CrApplication implements CommandLineRunner{

	@Autowired
	private IPropietarioService propietarioService;
		
	public static void main(String[] args){
		SpringApplication.run(Pa2U4P4CrApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Propietario prop = new Propietario();
		prop.setNombre("Cristina");
		prop.setApellido("Rivera");
		prop.setCedula("1726600537");
		
		Propietario prop2 = new Propietario();
		prop2.setNombre("Margarita");
		prop2.setApellido("Valencia");
		prop2.setCedula("1726600537");
		
		this.propietarioService.agregar(prop);
		this.propietarioService.agregar(prop2);
		
	}
	
	
}
