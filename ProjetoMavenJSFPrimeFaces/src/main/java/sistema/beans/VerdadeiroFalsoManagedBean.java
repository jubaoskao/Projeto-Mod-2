package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.VerdadeiroFalso;
import sistema.service.VerdadeiroFalsoService;

@ManagedBean
@ViewScoped
public class VerdadeiroFalsoManagedBean {

	private VerdadeiroFalso verdadeiroFalso = new VerdadeiroFalso();
	private List<VerdadeiroFalso> verdadeiroFalsos;
	private VerdadeiroFalsoService service = new VerdadeiroFalsoService();

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
