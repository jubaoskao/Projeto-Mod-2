package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Aluno;
import sistema.modelos.Disciplina;
import sistema.modelos.Professor;
import sistema.service.DisciplinaService;
import sistema.service.ProfessorService;

@ManagedBean(name = "professorManagedBean")
@ViewScoped
public class ProfessorManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor = new Professor();
	private Disciplina disciplina;
	private ProfessorService prodService = new ProfessorService();
	private DisciplinaService discService = new DisciplinaService();
	private List<Professor> professors;

	public void salvar() {
		disciplina.addProfessor(professor);
		professor.setDisciplina(disciplina);

		professor = prodService.salvar(professor);

		if (professors != null)
			professors.add(professor);

		professor = new Professor();
		disciplina = null;

	}

	public List<Disciplina> getDisciplinaes() {
		return discService.getDisciplinas();

	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void remove(Professor professor) {
		prodService.remover(professor);
		professors.remove(professor);
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessors() {
		if (professors == null)
			professors = prodService.getProfessors();

		return professors;
	}

	public void onRowEdit(RowEditEvent event) {

		Professor p = ((Professor) event.getObject());
		prodService.alterar(p);
	}

}
