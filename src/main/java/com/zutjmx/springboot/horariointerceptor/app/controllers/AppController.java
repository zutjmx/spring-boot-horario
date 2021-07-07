package com.zutjmx.springboot.horariointerceptor.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;

	@GetMapping({"/","/index"})
	public String index(Model modelo) {
		modelo.addAttribute("titulo", "Bienvenido al horario de atención a clientes.");
		return "index";
	}
	
	@GetMapping("/cerrado")
	public String cerrado(Model modelo) {
		
		StringBuilder mensaje = new StringBuilder("Visitenos desde las "); 
		mensaje.append(apertura);
		mensaje.append(" hrs. ");
		mensaje.append("y hasta las ");
		mensaje.append(cierre);
		mensaje.append(" hrs. ");
		mensaje.append("Gracias por su visita");
		
		modelo.addAttribute("titulo", "Fuera del horario de servicio.");
		modelo.addAttribute("mensaje", mensaje.toString());
		
		return "cerrado";
	}
	
}
