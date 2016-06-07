package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import sistema.modelos.Disciplina;
import sistema.service.DisciplinaService;

@ManagedBean
@ViewScoped
public class DisciplinaManagedBean {

	private Disciplina disciplina = new Disciplina();
	private List<Disciplina> disciplinas;
	private DisciplinaService service = new DisciplinaService();

	// Edição de uma disciplina na tabela
	public void onRowEdit(RowEditEvent event) {

		Disciplina a = ((Disciplina) event.getObject());
		service.alterar(a);
	}

	public void salvar() {
		disciplina = service.salvar(disciplina);

		if (disciplinas != null)
			disciplinas.add(disciplina);

		disciplina = new Disciplina();

	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	// Retorna a lista de disciplinas para a tabela
	public List<Disciplina> getDisciplinas() {
		if (disciplinas == null)
			disciplinas = service.getDisciplinas();

		return disciplinas;
	}

	public void remover(Disciplina disciplina) {
		service.remover(disciplina);
		disciplinas.remove(disciplina);

	}

}
