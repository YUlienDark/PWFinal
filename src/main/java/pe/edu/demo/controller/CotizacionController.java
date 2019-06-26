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
import pe.edu.demo.model.entity.Cotizacion;
import pe.edu.demo.model.entity.Producto;
import pe.edu.demo.service.ClienteService;
import pe.edu.demo.service.CotizacionService;
import pe.edu.demo.service.ProductoService;

@Controller
@RequestMapping("/cotizacion")
@SessionAttributes("cotizacion")
public class CotizacionController {
	@Autowired
	private CotizacionService cotiservice;
	
	@Autowired
	private ProductoService produservice;
	
	@Autowired
	private ClienteService cliservice;
	
	@GetMapping
	public String listado(Model model)
	{
		try {
		List<Cotizacion> cotizaciones = cotiservice.findAll();
		model.addAttribute("cotizaciones",cotizaciones);
		}
		catch(Exception e)
		{
			model.addAttribute("error", e.getMessage());
		}
		return "/cotizacion/lista";
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("txtId") Integer id ,Model model)
	{
		try {
			Optional<Cotizacion> buscado = cotiservice.findById(id);
			List<Cotizacion> cotizaciones= new ArrayList<>();
			if(buscado.isPresent())
			{
				cotizaciones.add(buscado.get());
			}
			model.addAttribute("cotizaciones", cotizaciones);
		}catch(Exception e)
		{
			model.addAttribute("error", "Error en obtener la lista");
		}
		return "/cotizacion/lista";
	}
	

	@GetMapping("/edit/{id}")
	public String editar (@PathVariable("id")Integer id , Model model)
	{
		try {
			Optional<Cotizacion> buscado = cotiservice.findById(id);
			if(buscado.isPresent())
			{
				model.addAttribute("cotizacion", buscado.get());
				List<Cliente> clientes = cliservice.findAll();
				model.addAttribute("clientes", clientes);	
				List<Producto> productos = produservice.findAll();
				model.addAttribute("productos", productos);				
			}
			else
			{
				model.addAttribute("error", "Cotizacion no encontrada");
			}
		}catch(Exception e)
		{
			model.addAttribute("error", "Cotizacion no encontrada");
					
		}
		return "/cotizacion/edit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("cotizacion") Cotizacion cotizacion,Model model,SessionStatus status)
	{
	try {
		cotiservice.save(cotizacion);
		status.setComplete();
		model.addAttribute("success", "Cotizacion guardada");
		
	}catch(Exception e)
	{
		model.addAttribute("error", "Cotizacion no guardada");
	}
	return "redirect:/cotizacion";
	}
	
	@GetMapping("/new")
	public String nuevo(Model model)
	{
		try {
			
			Cotizacion cotizacion= new Cotizacion();
			
			Optional<Cliente> cliente= cliservice.findById(1);
			cotizacion.setCliente(cliente.get());
			Optional<Producto> producto= produservice.findById(1);
			cotizacion.setProducto(producto.get());
			
			
			List<Cliente> clientes = cliservice.findAll();
			model.addAttribute("clientes", clientes);
			
			List<Producto> productos= produservice.findAll();
			model.addAttribute("productos", productos);
			model.addAttribute("cotizacion", cotizacion);

			
			
		}catch(Exception e)
		{
			model.addAttribute("error", "Cotizacion no guardado");
		}
		return "/cotizacion/new";
	}
	
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id , Model model)
	{
		try {Optional<Cotizacion> buscado = cotiservice.findById(id);
		if(buscado.isPresent())
		{
			cotiservice.deleteById(id);
		}
			
		}catch(Exception e)
		{
			model.addAttribute("error", "Cotizacion no eliminada");
		}
		return "redirect:/cotizacion";
	}
}



