package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Aluno;
import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;
import sistema.modelos.Pergunta;
import sistema.modelos.Produto;
import sistema.modelos.Professor;
import sistema.modelos.Prova;
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
	private List<Pergunta> perguntas;
	private PerguntaService service = new PerguntaService();
	private DisciplinaService dservice = new DisciplinaService();
	private ConteudoService cservice = new ConteudoService();
	private ProfessorService pservice = new ProfessorService();
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Disciplina> getDisciplinas() {
		return dservice.getDisciplinas();
	}
	public List<Conteudo> getConteudos() {
		return cservice.getConteudos();
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	
	// Edição de um prova na tabela
	public void onRowEdit(RowEditEvent event) {
		Pergunta a = ((Pergunta) event.getObject());
		service.alterar(a);
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
		pergunta.setDisciplina(disciplina);
		service.salvar(pergunta);
		
		if(perguntas != null)
			perguntas.add(pergunta);
		
		pergunta = new Pergunta();
		return null;
	}

	public void remover(Pergunta pergunta) {
		service.remover(pergunta);
		perguntas.remove(pergunta);
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
