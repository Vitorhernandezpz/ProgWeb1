package br.com.senac.initialization;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AlunoRepository;
import br.com.senac.repository.CursoRepository;
import br.com.senac.repository.TurmaRepository;
//import br.com.senac.repository.AlunoRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private AlunoService alunoService;
	@Autowired
	ProfessorService professorService;
	@Autowired
	CursoService cursoService;
	@Autowired
	private TurmaService turmaService;
	@Autowired
	TurmaRepository TurmaRepo;
	@Autowired
	AlunoRepository AlunoRepo;
	@Autowired
	CursoRepository CursoRepo;
	//@Autowired
	//AlunoRepository repo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Curso curso1 = new Curso();
		curso1.setNome("Python");
		Curso curso2 = new Curso();
		curso2.setNome("Prog Web 1");
		Curso curso3 = new Curso();
		curso3.setNome("Testes de Software");
		Curso curso4 = new Curso();
		curso4.setNome("Projeto Integrador");
		
		CursoRepo.saveAll(Arrays.asList(curso1, curso2, curso3, curso4));	
		
		List<Curso> listacursos1 = new ArrayList();
		listacursos1.add(curso1);
		listacursos1.add(curso3);
		
		List<Curso> listacursos2 = new ArrayList();
		listacursos2.add(curso2);
		listacursos2.add(curso4);
		
		List<Curso> listacursos3 = new ArrayList();
		listacursos3.add(curso2);
		listacursos3.add(curso3);
		
		System.out.println("-----------------------------");
				
		Turma turma1 = new Turma();
		turma1.setNome("ADS2021.1");
		turma1.setCursos(listacursos1);
		Turma turma2 = new Turma();
		turma2.setNome("ADS2021.2");
		turma2.setCursos(listacursos2);
		Turma turma3 = new Turma();
		turma3.setNome("ADS2018.1");
		turma3.setCursos(listacursos3);
		
		//turmaService.insert(turma1);
		//turmaService.insert(turma2);
		//turmaService.insert(turma3);
		
		TurmaRepo.saveAll(Arrays.asList(turma1,turma2,turma3));
		System.out.println("-----------------------------");
		
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Rogerio");
		aluno1.setTurma(turma1);
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Alfredo");
		aluno2.setTurma(turma2);
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Juleide");
		aluno3.setTurma(turma3);
		
		//alunoService.insert(aluno1);
		//alunoService.insert(aluno2);
		//alunoService.insert(aluno3);
		
		AlunoRepo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));		
		System.out.println("-----------------------------");
		System.out.println("-----------------------------");
		
		
	}
}
