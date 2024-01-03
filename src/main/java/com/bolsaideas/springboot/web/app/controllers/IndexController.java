package com.bolsaideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index", "/home", "/"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Matias");
		usuario.setApellido("Pinto");
		usuario.setEmail("matias25pinto@gmail.com");
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {

			model.addAttribute("titulo", textoListar);
			return "listar";
		
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		/*List<Usuario> usuarios = new ArrayList<>();
		
		usuarios.add(new Usuario("Matias","Pinto","matias25pinto@gmail.com"));
		usuarios.add(new Usuario("John", "Doe", "john_doe@gmail.com"));
		usuarios.add(new Usuario("Jane", "Doe", "jane_doe@gmail.com"));
		*/
		List<Usuario> usuarios = Arrays.asList(new Usuario("Matias","Pinto","matias25pinto@gmail.com"), new Usuario("John", "Doe", "john_doe@gmail.com"), new Usuario("Jane", "Doe", "jane_doe@gmail.com"));
		return usuarios;
	}
	
}
