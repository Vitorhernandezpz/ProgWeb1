package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Turma;
import br.com.senac.service.CursoService;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/listarTurmas")
	public ModelAndView listaTodosTurma() {
		ModelAndView mv = new ModelAndView("turma/paginaListaTurmas");
		mv.addObject("turma", turmaService.selectAll());
		return mv;
	}
	
	@GetMapping("/cadastrarTurma")//http://localhost:8080/aluno/cadastrarAluno
	public ModelAndView cadastrarTurma() {
		ModelAndView mv = new ModelAndView("turma/cadastrarTurma");
		mv.addObject("turma", new Turma());
		mv.addObject("listaCursos", cursoService.selectAll());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarTurma(Turma turma) {
		turmaService.insert(turma);
		return listaTodosTurma();
	}
	
	@GetMapping("/paginaAlterar/{id}")
	public ModelAndView alterarAluno(@PathVariable("id")Integer id) {
		ModelAndView mv = new ModelAndView("turma/alterarTurma");
		mv.addObject("turma", turmaService.select(id));
		return mv;
	}
	
	@PostMapping("/salvarAlteracao")
	public ModelAndView alterar(Turma turmaAlterado) {
		turmaService.salvarAlteracao(turmaAlterado);
		return listaTodosTurma();	
	}
	
	@GetMapping("/excluir/{idX}")
	public ModelAndView excluirAluno(@PathVariable("idX")Integer id) {
		turmaService.delete(id);
		return listaTodosTurma();
	}
}
