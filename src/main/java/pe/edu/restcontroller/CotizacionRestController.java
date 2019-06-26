package pe.edu.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.edu.demo.model.entity.Cotizacion;
import pe.edu.demo.service.CotizacionService;

@RestController
@RequestMapping("/cotizaciones")
@Api(value = "Rest for Cotizaciones")
public class CotizacionRestController {
	
	@Autowired
	private CotizacionService cotiservice;
	
	@ApiOperation("Find all cotizaciones")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cotizacion>> findall()
	{
		try 
		{
			List<Cotizacion> cotizaciones = cotiservice.findAll();
			return new ResponseEntity<List<Cotizacion>>(cotizaciones,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<List<Cotizacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
