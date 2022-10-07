package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Curso;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping("curso")
public class CursoController {
	@Autowired
	private CursoService cursoService;
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/listarCursos")
	public ModelAndView listaTodosCursos() {
		ModelAndView mv = new ModelAndView("curso/paginaListaCursos");
		mv.addObject("cursos", cursoService.selectAll());
		return mv;
	}
	
	@GetMapping("/cadastrarCurso")//http://localhost:8080/aluno/cadastrarCurso
	public ModelAndView cadastrarCurso() {
		ModelAndView mv = new ModelAndView("curso/cadastrarCurso");
		mv.addObject("curso", new Curso());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCurso(Curso curso) {
		cursoService.insert(curso);
		return listaTodosCursos();

	}
	
	@GetMapping("/paginaAlterar/{id}")
	public ModelAndView alterarAluno(@PathVariable("id")Integer id) {
		ModelAndView mv = new ModelAndView("curso/alterarCurso");
		mv.addObject("curso", cursoService.select(id));
		return mv;
	}
	
	
	@PostMapping("/salvarAlteracao")
	public ModelAndView alterarCurso(Curso cursoAlterado) {
		cursoService.salvarAlteracao(cursoAlterado);
		return listaTodosCursos();
	}
	
	@GetMapping("/excluir/{idX}")
	public ModelAndView excluirAluno(@PathVariable("idX")Integer id) {
		cursoService.delete(id);
		return listaTodosCursos();
	}
}
