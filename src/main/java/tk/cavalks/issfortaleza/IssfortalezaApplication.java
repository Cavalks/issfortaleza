package tk.cavalks.issfortaleza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// TODO Salvamento em memória dos arquivos de certificados digitais para re-uso em outros envios
public class IssfortalezaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IssfortalezaApplication.class, args);
	}

}
