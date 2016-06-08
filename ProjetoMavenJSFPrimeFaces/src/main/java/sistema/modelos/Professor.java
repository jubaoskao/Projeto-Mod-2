package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int matricula;
	
	private String nome;
	private String curso;

	@OneToMany(mappedBy="professor")
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void addDisciplina(Disciplina disciplina)
	{
		disciplinas.add(disciplina);
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Professor [matricula=" + matricula + ", nome=" + nome + ", curso=" + curso + "]";
	}
	
	
	
	
	

}
