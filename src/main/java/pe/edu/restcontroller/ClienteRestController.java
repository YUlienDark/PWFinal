package pe.edu.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.edu.demo.model.entity.Cliente;
import pe.edu.demo.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@Api(value = "REST for Clientes")
public class ClienteRestController {
@Autowired
private ClienteService cliservice;

@ApiOperation("Fetch all clientes")
@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List <Cliente>> fetchAll()
{
	try {List<Cliente> clientes = cliservice.findAll();
		return new ResponseEntity <List<Cliente>>(clientes,HttpStatus.OK);
	}catch(Exception e)
	{
		return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@ApiOperation("Save Clientes")
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE )
public ResponseEntity<Object> save(@Valid @RequestBody Cliente cliente)
{
	try {
		Cliente tmp = cliservice.save(cliente);
		if(tmp != null)
		{
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}catch(Exception e)
	{
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@ApiOperation("Update Clientes")
@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> update(@Valid @RequestBody Cliente cliente)
{
	try {Optional<Cliente> searched = cliservice.findById(cliente.getIdCliente());
			if(searched.isPresent())
			{
				cliservice.update(cliente);
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

@ApiOperation("Fetch comprobante by id")
@GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Cliente> fetchById(@PathVariable("id") int id)
{
try {
	Optional<Cliente> cliente = cliservice.findById(id);
	if(cliente.isPresent())
	{
		return new ResponseEntity<Cliente>(cliente.get(),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	}
}
catch(Exception e)
{
	return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
}
}

@ApiOperation("Delete Cliente from id")
@DeleteMapping(value = "/{id}",produces = "text/plain")
public ResponseEntity<String> deleteById(@PathVariable("id") Integer id)
{
try {Optional<Cliente> searched =cliservice.findById(id);
if(searched.isPresent())
{
	cliservice.deleteById(id);
    return new ResponseEntity<String>("Entity eliminado",HttpStatus.OK);
}else
{
	return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
}


}catch(Exception e)
{
	return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}

@ApiOperation("Delete all Clientes")
@DeleteMapping(produces = "text/plain")
public ResponseEntity <String> deleteall()
{
	try {
		cliservice.deleteAll();
		return new ResponseEntity<String>(HttpStatus.OK);
	}catch(Exception e)
	{
		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@ApiOperation("Fetch from Razon")
@GetMapping(value ="/{razon}",produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Cliente>> fetchByrazon(@PathVariable("razon") String razon)
{
	try {
		List<Cliente> clientes = cliservice.findRazon(razon);
		if(!clientes.isEmpty())
		{
	return new ResponseEntity<List<Cliente>>(HttpStatus.OK);
	
	}
		else
		{
			return new ResponseEntity<List<Cliente>>(HttpStatus.NOT_FOUND);
		}
	}catch(Exception e)
	{
   		return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}

