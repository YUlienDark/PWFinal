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

import pe.edu.demo.model.entity.Empleado;
import pe.edu.demo.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
@SessionAttributes("empleado")
public class EmpleadoController {
	@Autowired
	private EmpleadoService empleservice;
	
	@GetMapping
	public String listado(Model model)
	{
		try {
		List<Empleado> empleados = empleservice.findAll();
		model.addAttribute("empleados",empleados);
		}
		catch(Exception e)
		{
			model.addAttribute("error", e.getMessage());
		}
		return "/empleado/lista";
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("txtId") Integer id ,Model model)
	{
		try {
			Optional<Empleado> buscado = empleservice.findById(id);
			List<Empleado> empleados= new ArrayList<>();
			if(buscado.isPresent())
			{
				empleados.add(buscado.get());
			}
			model.addAttribute("empleados", empleados);
		}catch(Exception e)
		{
			model.addAttribute("error", "Error en obtener la lista");
		}
		return "/empleado/lista";
	}
	@GetMapping("/buscarNombreApellido")
	public String buscarNombreApellido(@RequestParam("Nombreempleado" )String nombre,@RequestParam("Apellidoempleado") String apellido ,Model model)
	{
		try {
			
			List<Empleado> empleados= empleservice.findByNombreApellido(nombre, apellido);
			
			model.addAttribute("empleados", empleados);
		}catch(Exception e)
		{
			model.addAttribute("error", "Error en obtener la lista");
		}
		return "/empleado/lista";
	}
	
	@GetMapping("/edit/{id}")
	public String editar (@PathVariable("id")Integer id , Model model)
	{
		try {
			Optional<Empleado> buscado = empleservice.findById(id);
			if(buscado.isPresent())
			{
				model.addAttribute("empleado", buscado.get());
			
			}
			else
			{
				model.addAttribute("error", "Empleado no encontrado");
			}
		}catch(Exception e)
		{
			model.addAttribute("error", "Empleado no encontrado");
					
		}
		return "/empleado/edit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("empleado") Empleado empleado,Model model,SessionStatus status)
	{
	try {
		empleservice.save(empleado);
		status.setComplete();
		model.addAttribute("success", "Empleado guardado");
		System.out.println(empleado.getApellidoempleado());
		
	}catch(Exception e)
	{
		
		model.addAttribute("error", e.getMessage());
		System.out.println(empleado.getApellidoempleado());
	}
	return "redirect:/empleado";
	}
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		try {
			Empleado empleado = new Empleado();
					
			model.addAttribute("empleado", empleado);
			
		
		} catch (Exception e) {
			model.addAttribute("error", "Empleado no guardado");
		}
		
		return "/empleado/new"; 
	}
	
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id , Model model)
	{
		try {Optional<Empleado> buscado = empleservice.findById(id);
		if(buscado.isPresent())
		{
			empleservice.deleteById(id);
		}
			
		}catch(Exception e)
		{
			model.addAttribute("error", "Empleado no eliminado");
		}
		return "redirect:/empleado";
	}
}



