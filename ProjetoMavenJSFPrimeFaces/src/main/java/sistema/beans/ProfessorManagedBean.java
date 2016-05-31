package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@ViewScoped
public class ProfessorManagedBean {

	private Professor professor = new Professor();
	private List<Professor> professores;
	private ProfessorService service = new ProfessorService();

	// Edi��o de um professor na tabela
	public void onRowEdit(RowEditEvent event) {

		Professor a = ((Professor) event.getObject());
		service.alterar(a);
	}

	public void salvar() {
		professor = service.salvar(professor);

		if (professores != null)
			professores.add(professor);

		professor = new Professor();

	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	// Retorna a lista de professores para a tabela
	public List<Professor> getProfessors() {
		if (professores == null)
			professores = service.getProfessors();

		return professores;
	}

	public void remover(Professor professor) {
		service.remover(professor);
		professores.remove(professor);

	}

}
