package sistema.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;
import sistema.modelos.PDFWithText;
import sistema.modelos.Pergunta;
import sistema.modelos.Prova;
import sistema.service.PerguntaService;
import sistema.service.ProvaService;

@ManagedBean
@ViewScoped
public class ProvaManagedBean {

	private Prova prova = new Prova();
	private List<Prova> provas;
	private Disciplina disciplina;
	private Conteudo conteudo;
	private ProvaService service = new ProvaService();
	private PerguntaService pservice = new PerguntaService();
	private PerguntaManagedBean perg = new PerguntaManagedBean();

	// Edição de um prova na tabela
	public void onRowEdit(RowEditEvent event) {

		Prova a = ((Prova) event.getObject());
		service.alterar(a);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	
	public void salvar() {
		prova = service.salvar(prova);

		if (provas != null)
			provas.add(prova);

		prova = new Prova();
	}
	
	public void gerar(Prova prova) throws IOException
	{
		int count = 1;
		PDFWithText p  = new PDFWithText();
		
		List<Pergunta> lista = pservice.getPerguntas(prova.getNivelProva());
		p.createPDF(lista, prova.getNome(), prova.getQtdePerguntas());
		prova = new Prova();
	}	

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	// Retorna a lista de provas para a tabela
	public List<Prova> getProvas() {
		if (provas == null)
			provas = service.getProvas();
		
		List<Prova> aux = new ArrayList<Prova>();
		
		Stream <? extends Prova> stream = provas.
				 stream().
				 filter( s -> s.getNome() != null );
		stream.forEach(p -> aux.add(p));
		
		return aux;
	}

	public void remover(Prova prova) {
		service.remover(prova);
		provas.remove(prova);

	}

}
