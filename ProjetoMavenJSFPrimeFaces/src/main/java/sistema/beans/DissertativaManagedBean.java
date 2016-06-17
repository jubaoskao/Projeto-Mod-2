package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Dissertativa;
import sistema.modelos.Pergunta;
import sistema.service.DissertativaService;
import sistema.service.PerguntaService;
import sistema.service.VerdadeiroFalsoService;

@ManagedBean
@ViewScoped
public class DissertativaManagedBean {

	private Dissertativa dissertativa = new Dissertativa();
	private List<Dissertativa> dissertativas;
	private DissertativaService service = new DissertativaService();
	private Pergunta pergunta;
	private PerguntaService pserv = new PerguntaService();

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
	
	
	// Edição de um dissertativa na tabela
	public void onRowEdit(RowEditEvent event) {

		Dissertativa a = ((Dissertativa) event.getObject());
		service.alterar(a);
	}

	public void salvar() {
		dissertativa = service.salvar(dissertativa);

		if (dissertativas != null)
			dissertativas.add(dissertativa);

		dissertativa = new Dissertativa();

	}

	public Dissertativa getDissertativa() {
		return dissertativa;
	}

	public void setDissertativa(Dissertativa dissertativa) {
		this.dissertativa = dissertativa;
	}

	// Retorna a lista de dissertativas para a tabela
	public List<Dissertativa> getDissertativas() {
		if (dissertativas == null)
			dissertativas = service.getDissertativas();

		return dissertativas;
	}

	public void remover(Dissertativa dissertativa) {
		service.remover(dissertativa);
		dissertativas.remove(dissertativa);

	}

}
