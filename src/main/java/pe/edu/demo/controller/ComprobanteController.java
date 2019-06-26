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

import pe.edu.demo.model.entity.Comprobante;
import pe.edu.demo.model.entity.Cotizacion;
import pe.edu.demo.model.entity.Empleado;
import pe.edu.demo.service.ComprobanteService;
import pe.edu.demo.service.CotizacionService;
import pe.edu.demo.service.EmpleadoService;

@Controller
@RequestMapping("/comprobante")
@SessionAttributes("comprobante")
public class ComprobanteController {
	@Autowired
	private ComprobanteService comproservice;
	@Autowired
	private CotizacionService cotiservice;
	@Autowired
	private EmpleadoService empleservice;
	
	@GetMapping
	public String listado(Model model)
	{
		try {
		List<Comprobante> comprobantes = comproservice.findAll();
		model.addAttribute("comprobantes",comprobantes);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			model.addAttribute("error", e.getMessage());
		}
		return "/comprobante/lista";
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("txtId") Integer id ,Model model)
	{
		try {
			Optional<Comprobante> buscado = comproservice.findById(id);
			List<Comprobante> comprobantes= new ArrayList<>();
			if(buscado.isPresent())
			{
				comprobantes.add(buscado.get());
			}
			model.addAttribute("comprobantes", comprobantes);
		}catch(Exception e)
		{
			model.addAttribute("error", e.getMessage());
		} 
		return "/comprobante/lista";
	}
	
	@GetMapping("/edit/{id}")
	public String editar (@PathVariable("id")Integer id , Model model)
	{
		try {
			Optional<Comprobante> buscado = comproservice.findById(id);
			if(buscado.isPresent())
			{
				model.addAttribute("comprobante", buscado.get());
				List<Cotizacion> cotizaciones = cotiservice.findAll();
				model.addAttribute("cotizaciones", cotizaciones);
				List<Empleado> empleados = empleservice.findAll();
				model.addAttribute("empleados",empleados);
			}
			else
			{
				model.addAttribute("error", "Comprobante no encontrado");
			}
		}catch(Exception e)
		{
			model.addAttribute("error", "Comprobante no encontrado");
					
		}
		return "/comprobante/edit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("comprobante") Comprobante comprobante,Model model,SessionStatus status)
	{
	try {
		comproservice.save(comprobante);
		status.setComplete();
		model.addAttribute("success", "Comprobante guardado");
		
	}catch(Exception e)
	{
		model.addAttribute("error", e.getMessage());
	}
	return "redirect:/comprobante";
	}
	@GetMapping("/new")
	public String nuevo(Model model)
	{
		try {
			Comprobante comprobante= new Comprobante();
			
		    Optional<Cotizacion> cotizacion = cotiservice.findById(1);
		    Optional<Empleado> empleado = empleservice.findById(1);
			comprobante.setCotizacion(cotizacion.get());
			comprobante.setEmpleado(empleado.get());
	
			
			
			List<Cotizacion> cotizaciones = cotiservice.findAll();
			model.addAttribute("cotizaciones", cotizaciones);
			
			
			List<Empleado> empleados = empleservice.findAll();
			model.addAttribute("empleados", empleados);
			
			model.addAttribute("comprobante", comprobante);
			
			
		}catch(Exception e)
		{
			model.addAttribute("error", "Comprobante no guardada");
		}
		return "/comprobante/new";
	}
	
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id , Model model)
	{
		try {Optional<Comprobante> buscado = comproservice.findById(id);
		if(buscado.isPresent())
		{
			comproservice.deleteById(id);
		}
			
		}catch(Exception e)
		{
			model.addAttribute("error", "Comprobante no eliminado");
		}
		return "redirect:/comprobante";
	}
}
