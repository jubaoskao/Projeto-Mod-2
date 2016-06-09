package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Alternativa;
import sistema.service.AlternativaService;

@ManagedBean
@ViewScoped
public class AlternativaManagedBean {

	private Alternativa alternativa = new Alternativa();
	private List<Alternativa> alternativas;
	private AlternativaService service = new AlternativaService();

	// Edição de um alternativa na tabela
	public void onRowEdit(RowEditEvent event) {

		Alternativa a = ((Alternativa) event.getObject());
		service.alterar(a);
	}

	public void salvar() {
		alternativa = service.salvar(alternativa);

		if (alternativas != null)
			alternativas.add(alternativa);

		alternativa = new Alternativa();

	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

	// Retorna a lista de alternativas para a tabela
	public List<Alternativa> getAlternativas() {
		if (alternativas == null)
			alternativas = service.getAlternativas();

		return alternativas;
	}

	public void remover(Alternativa alternativa) {
		service.remover(alternativa);
		alternativas.remove(alternativa);

	}

}
