package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;



@Controller
@RequestMapping("/app")
public class IndexController {

	@RequestMapping({"/index","/","","/home"})
	public String index(Model model) {
		
		model.addAttribute("titulo", "Hola spring Framework");
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario usu = new Usuario();
		usu.setNombre("Nelson");
		usu.setApellido("Gomez");
		usu.setEmail("n00gomez00@gmail.com");
		model.addAttribute("titulo", "Perfil del usuario "+usu.getNombre());
		model.addAttribute("usuario", usu);
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Lista de Usuarios ");
		
		return "listar";
	}
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Nelson","Gomez","n00gomez00@gmail.com"));
		usuarios.add(new Usuario("Karen","Guzman","karen@gmail.com"));
		usuarios.add(new Usuario("Pedro","Perez","pp@gmail.com"));
		usuarios.add(new Usuario("Manuel","Gonzalez","manu@gmail.com"));
		return usuarios;
	}
}
