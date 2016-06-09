package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Aluno;
import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;
import sistema.modelos.Pergunta;
import sistema.modelos.Professor;
import sistema.service.AlunoService;
import sistema.service.ConteudoService;
import sistema.service.PerguntaService;
import sistema.service.ProfessorService;
import sistema.service.DisciplinaService;

@ManagedBean(name = "perguntaManagedBean")
@SessionScoped
public class PerguntaManagedBean {
	
	private static final long serialVersionUID = 1L;
	private Pergunta pergunta = new Pergunta();
	private Disciplina disciplina;
	private Conteudo conteudo;
	private PerguntaService service = new PerguntaService();
	private DisciplinaService dservice = new DisciplinaService();
	private ConteudoService cservice = new ConteudoService();
	private ProfessorService pservice = new ProfessorService();
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Disciplina> getDisciplinas() {
		List<Disciplina> p = dservice.getDisciplinas();
		if(p.size() == 0)
		{
			Professor p1 = new Professor();
			p1.setDescricao("Glaucao");
			pservice.salvar(p1);
			
			Disciplina d1 = new Disciplina();
			Disciplina d2 = new Disciplina();
			Disciplina d3 = new Disciplina();
			
			d1.setNome("POOI");
			d1.addProfessor(p1);
			d2.setNome("POOII");
			d2.addProfessor(p1);
			d3.setNome("CompGrafica");
			d3.addProfessor(p1);
			dservice.salvar(d1);
			dservice.salvar(d2);
			dservice.salvar(d3);
			p.add(d1);
			p.add(d2);
			p.add(d3);
		}
		return p;
	}
	public List<Conteudo> getConteudos() {
		List<Conteudo> p = cservice.getConteudos();
		if(p.size() == 0)
		{
			Conteudo d1 = new Conteudo();
			Conteudo d2 = new Conteudo();
			Conteudo d3 = new Conteudo();
			
			d1.setNome("Java");
			d2.setNome("JSF");
			d3.setNome("JPA");
			cservice.salvar(d1);
			cservice.salvar(d2);
			cservice.salvar(d3);
			p.add(d1);
			p.add(d2);
			p.add(d3);
		}
		return p;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String salvar()
	{
		pergunta.addConteudo(conteudo);
		service.salvar(pergunta);
		pergunta = new Pergunta();
		return null;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public List<Pergunta> getPerguntas() {
		return service.getPerguntas();
	}
}
