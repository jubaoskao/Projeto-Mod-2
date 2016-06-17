package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Pergunta;
import sistema.modelos.VerdadeiroFalso;
import sistema.service.PerguntaService;
import sistema.service.VerdadeiroFalsoService;

@ManagedBean
@ViewScoped
public class VerdadeiroFalsoManagedBean {

	private VerdadeiroFalso verdadeiroFalso = new VerdadeiroFalso();
	private List<VerdadeiroFalso> verdadeiroFalsos;
	private Pergunta pergunta;
	private PerguntaService pserv = new PerguntaService();
	private VerdadeiroFalsoService service = new VerdadeiroFalsoService();


	public List<Pergunta> getPerguntas()
	{
		return pserv.getPerguntas();
	}
	
	
	
	public Pergunta getPergunta() {
		return pergunta;
	}



	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	// Edição de um verdadeiroFalso na tabela
	public void onRowEdit(RowEditEvent event) {

		VerdadeiroFalso a = ((VerdadeiroFalso) event.getObject());
		service.alterar(a);
	}

	public void salvar() {
		verdadeiroFalso = service.salvar(verdadeiroFalso);

		if (verdadeiroFalsos != null)
			verdadeiroFalsos.add(verdadeiroFalso);

		verdadeiroFalso = new VerdadeiroFalso();

	}

	public VerdadeiroFalso getVerdadeiroFalso() {
		return verdadeiroFalso;
	}

	public void setVerdadeiroFalso(VerdadeiroFalso verdadeiroFalso) {
		this.verdadeiroFalso = verdadeiroFalso;
	}

	// Retorna a lista de verdadeiroFalsos para a tabela
	public List<VerdadeiroFalso> getVerdadeiroFalsos() {
		if (verdadeiroFalsos == null)
			verdadeiroFalsos = service.getVerdadeiroFalsos();

		return verdadeiroFalsos;
	}

	public void remover(VerdadeiroFalso verdadeiroFalso) {
		service.remover(verdadeiroFalso);
		verdadeiroFalsos.remove(verdadeiroFalso);

	}

}
