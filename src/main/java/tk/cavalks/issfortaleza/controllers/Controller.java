package tk.cavalks.issfortaleza.controllers;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tk.cavalks.issfortaleza.services.EnvioRPSService;

//TODO resources de uso real para aplicação baseando-se nos jsons
@RestController
public class Controller {

	@PostMapping("/envio-lote-rps")
	public ResponseEntity<String> envioLoteRPS(@RequestParam("certificado") MultipartFile file, @RequestParam("senha") String senha) {
		try {
			return ResponseEntity.ok(EnvioRPSService.enviarLoteRPS(file.getInputStream(), senha));
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sw.toString());
		}
	}
}
