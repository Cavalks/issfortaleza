package tk.cavalks.issfortaleza.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		try {
			return EnvioRPSService.enviarLoteRPS();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Helo, "+ name;
	}
}
