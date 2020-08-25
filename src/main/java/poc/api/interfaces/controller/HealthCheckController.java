package poc.api.interfaces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {
	

	@GetMapping("/v1")
	public String getHealthCheck() {
		return "POC API Interfaces - Version 1.0.0";
	}
}
