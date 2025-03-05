package pe.com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import pe.com.demo.entity.Persona;
import pe.com.demo.repository.PersonaRepository;

import java.util.List;

@SpringBootApplication
@Transactional
public class DemoJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonaRepository personaRepository;

//	private DemoJpaApplication(PersonaRepository personaRepository){
//		this.personaRepository=personaRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Persona> lista = personaRepository.findAll();
//		lista.forEach(x -> System.out.println(x));


		this.personaRepository.updateSalario(2200, 1);

		List<Persona> obj = this.personaRepository.findByName("Ric");
		System.out.println(obj);
	}
}
