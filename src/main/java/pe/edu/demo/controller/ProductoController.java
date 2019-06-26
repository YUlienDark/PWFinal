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

import pe.edu.demo.model.entity.Cotizacion;
import pe.edu.demo.model.entity.Producto;
import pe.edu.demo.service.CotizacionService;
import pe.edu.demo.service.ProductoService;

@Controller
@RequestMapping("/producto")
@SessionAttributes("producto")
public class ProductoController {

	@Autowired
	private ProductoService produservice;
	
	@Autowired
	private CotizacionService cotiservice;
	@GetMapping
	public String listado(Model model)
	{
		try {
		List<Producto> productos = produservice.findAll();
		model.addAttribute("productos",productos);
		}
		catch(Exception e)
		{
			model.addAttribute("error", e.getMessage());
		}
		return "/producto/lista";
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("txtId") Integer id ,Model model)
	{
		try {
			Optional<Producto> buscado = produservice.findById(id);
			List<Producto> productos= new ArrayList<>();
			if(buscado.isPresent())
			{
				productos.add(buscado.get());
			}
			model.addAttribute("productos", productos);
		}catch(Exception e)
		{
			model.addAttribute("error", "Error en obtener la lista");
		}
		return "/producto/lista";
	}
	@GetMapping("/buscarModelo")
	public String buscar(@RequestParam("modelo") String modelo,Model model)
	{
		try {
		
			List<Producto> productos= produservice.findModelo(modelo);
			
			model.addAttribute("productos", productos);
		}catch(Exception e)
		{
			model.addAttribute("error", "Error en obtener la lista");
		}
		return "/producto/lista";
	}
	
	@GetMapping("/edit/{id}")
	public String editar (@PathVariable("id")Integer id , Model model)
	{
		try {
			Optional<Producto> buscado = produservice.findById(id);
			if(buscado.isPresent())
			{
				model.addAttribute("producto", buscado.get());
				List<Cotizacion> cotizaciones = cotiservice.findAll();
				model.addAttribute("cotizaciones", cotizaciones);
			}
				
			else
			{
				model.addAttribute("error", "Producto no encontrado");
			}
		}catch(Exception e)
		{
			model.addAttribute("error", "Producto no encontrado");
					
		}
		return "/producto/edit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("producto") Producto producto,Model model,SessionStatus status)
	{
	try {
		produservice.save(producto);
		status.setComplete();
		model.addAttribute("success", "Producto guardado");
		
	}catch(Exception e)
	{
		model.addAttribute("error", "Producto no guardado");
	}
	return "redirect:/producto";
	}
	@GetMapping("/new")
	public String nuevo(Model model) {
		try {
			Producto producto = new Producto();
			
			  Optional<Cotizacion> cotizacion = cotiservice.findById(1);
			  producto.setCotizacion(cotizacion.get());
			  
			  
			  List<Cotizacion> cotizaciones = cotiservice.findAll();
			  model.addAttribute("cotizaciones", cotizaciones);
			 
			model.addAttribute("producto",producto );
		} catch (Exception e) {
			model.addAttribute("error", "Producto no guardado");
		}
		
		return "/producto/new"; 
	}
	
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id , Model model)
	{
		try {Optional<Producto> buscado = produservice.findById(id);
		if(buscado.isPresent())
		{
			produservice.deleteById(id);
		}
			
		}catch(Exception e)
		{
			model.addAttribute("error", "Producto no eliminado");
		}
		return "redirect:/producto";
	}
}


