package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Prova;
import sistema.service.ProvaService;

@ManagedBean
@ViewScoped
public class ProvaManagedBean {

	private Prova prova = new Prova();
	private List<Prova> provas;
	private ProvaService service = new ProvaService();

	// Edição de um prova na tabela
	public void onRowEdit(RowEditEvent event) {

		Prova a = ((Prova) event.getObject());
		service.alterar(a);
	}

	public void salvar() {
		prova = service.salvar(prova);

		if (provas != null)
			provas.add(prova);

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

		return provas;
	}

	public void remover(Prova prova) {
		service.remover(prova);
		provas.remove(prova);

	}

}
