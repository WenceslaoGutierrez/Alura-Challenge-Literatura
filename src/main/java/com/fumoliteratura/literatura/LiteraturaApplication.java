package com.fumoliteratura.literatura;

import com.fumoliteratura.literatura.principal.Principal;
import com.fumoliteratura.literatura.repository.AutorRepository;
import com.fumoliteratura.literatura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LibroRepository libroRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal=new Principal(libroRepository,autorRepository);
		principal.mostrarMenu();
	}

}
