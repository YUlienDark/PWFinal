package pe.edu.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.demo.model.entity.Cliente;
import pe.edu.demo.service.ClienteService;

@Controller
@RequestMapping("/cliente")
@SessionAttributes("cliente")
public class ClienteController {
    @Autowired
	private ClienteService cliservice;
    
   @GetMapping
   public String listado(Model model)
   {try {
	   List<Cliente> clientes = cliservice.findAll();
	   model.addAttribute("clientes", clientes);
   }
   catch(Exception e)
   {
	   model.addAttribute("error", "Error en obtener la lista");
	   
   }
   return "/cliente/lista";
   }
   


@GetMapping("/buscar")
public String buscar(@RequestParam("txtId")Integer id,Model model)
{
	try {
		Optional<Cliente> buscado = cliservice.findById(id);
		List<Cliente> clientes = new ArrayList<>();
		if(buscado.isPresent())
		{
			clientes.add(buscado.get());
			
		}
		model.addAttribute("clientes", clientes);
	}catch(Exception e)
	{
	model.addAttribute("error", "Error en obtener la lista");
	}
	return "/cliente/lista";
}

@GetMapping("/buscarRazonsocial")
public String buscar_Razonsocial(@RequestParam("Razonsocial")String razon,Model model)
{
	try {
		List<Cliente> clientes = cliservice.findRazon(razon);
		
		
		model.addAttribute("clientes", clientes);
	}catch(Exception e)
	{
	model.addAttribute("error", "Error en obtener la lista");
	}
	return "/cliente/lista";
}
@GetMapping("/edit/{id}")
public String editar(@PathVariable("id") Integer id , Model model)
{
	try {
		Optional<Cliente> buscado = cliservice.findById(id);
		if(buscado.isPresent())
		{
			model.addAttribute("cliente",buscado.get());
			
			
		}
		else {
		model.addAttribute("error","Cliente no entcontrado");
		}
	}catch(Exception e)
	{
		model.addAttribute("error","Cliente no entcontrado");
	}
	return "/cliente/edit";
}

@PostMapping("/save")
public String nuevo(@ModelAttribute("cliente") Cliente cliente,Model model,SessionStatus status) {
	try {
		cliservice.save(cliente);
		status.setComplete();
		model.addAttribute("success", "Cliente guardado");
		System.out.println(cliente.getIdCliente());
		System.out.println(cliente.getRazonsocial());
		System.out.println(cliente.getNum_doc());
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
		model.addAttribute("error", "Cliente no guardado");
	}
	return "redirect:/cliente";
}
@GetMapping("/new")
public String nuevo(Model model)
{
	try {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		
		
	}catch(Exception e)
	{
		model.addAttribute("error", "Cliente no guardado");
	}
	return "/cliente/new";
}
@GetMapping("/del/{id}")
public String del(@PathVariable("id") Integer id ,Model model)
{
	try {
		Optional<Cliente> buscado = cliservice.findById(id);
		if(buscado.isPresent())
		{
			cliservice.deleteById(id);
		}
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
		model.addAttribute("error", "Cliente no eliminado");
	}
	return "redirect:/cliente";
}



}