package mx.edu.uacm.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import mx.edu.uacm.rest.domain.Saludo;

@RestController
public class SaludoController {

	private static final String plantilla = "Hola %s";
	
	private final AtomicLong contador = new AtomicLong();
	
	// primera forma @RequestMapping(value="/saludame", method=RequestMethod.GET)
	@GetMapping("/saludame")
	@ApiOperation(value="obtiene una cadena de saludo", response=Saludo.class)
	public Saludo saludar(@RequestParam(name="tunombre", defaultValue="UACM") String nombre){
		
		long incrementado = contador.getAndIncrement();
		String formato = String.format(plantilla, nombre);
		
		return new Saludo(incrementado, formato);
	}
}
