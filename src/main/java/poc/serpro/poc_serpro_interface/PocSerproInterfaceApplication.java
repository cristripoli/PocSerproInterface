package poc.serpro.poc_serpro_interface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("poc.serpro")
public class PocSerproInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocSerproInterfaceApplication.class, args);
	}
}
