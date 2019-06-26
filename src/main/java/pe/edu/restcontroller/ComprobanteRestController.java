package pe.edu.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.edu.demo.model.entity.Comprobante;
import pe.edu.demo.service.ComprobanteService;

@RestController
@RequestMapping("/comprobantes")
@Api(value = "REST for Comprobantes")
public class ComprobanteRestController {
	
	@Autowired
	private ComprobanteService comproservice;
	
	@ApiOperation("Fetch all comprobantes")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Comprobante>> fetchAll()
	{
		try {
			List<Comprobante> comprobantes = comproservice.findAll();
			return new ResponseEntity<List<Comprobante>>(comprobantes ,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<List<Comprobante>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Comprobantes")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@Valid @RequestBody Comprobante comprobante)
	{
		try {
			Comprobante tmp = comproservice.save(comprobante);
			if(tmp != null)
			{
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch(Exception e)
		{
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Update Comprobante")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Comprobante comprobante)
	{
		try {
			Optional<Comprobante> searched = comproservice.findById(comprobante.getIdComprobante());
			if(searched.isPresent())
			{
				comproservice.update(comprobante);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		}catch(Exception e)
		
		{
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Find by id from Comprobantes")
	@GetMapping(value ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comprobante> fetchByid(@PathVariable("id") Integer id)
	{
		try {
			Optional<Comprobante> comprobante = comproservice.findById(id);
			if(comprobante.isPresent())
			{
				return new ResponseEntity <Comprobante>(comprobante.get(),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Comprobante>(HttpStatus.NOT_FOUND); 
			}
		}catch(Exception e)
		{
			return new ResponseEntity<Comprobante>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
	
	@ApiOperation("Remove by id")
	@GetMapping(value ="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comprobante> deletebyId(@PathVariable("id") Integer id)
	{
		try {
			Optional<Comprobante> searched = comproservice.findById(id);
			if(searched.isPresent())
			{
				comproservice.deleteById(id);
				return new ResponseEntity <Comprobante>(HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Comprobante>(HttpStatus.NOT_FOUND); 
			}
		}catch(Exception e)
		{
			return new ResponseEntity<Comprobante>(HttpStatus.INTERNAL_SERVER_ERROR); 
		}
	}
    @ApiOperation("Remove all")
    @GetMapping(produces = "text/plain")
    public ResponseEntity<String>  deleteall()
    {
    	try {
    		comproservice.deleteAll();
    		return new ResponseEntity<String>(HttpStatus.OK);
    	}catch(Exception e)
    	{
    		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
}

