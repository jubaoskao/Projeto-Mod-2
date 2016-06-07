package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Disciplina implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idDisciplina;
	private String nome;
	
	@OneToMany(mappedBy="disciplina")
	private List<Conteudo> conteudos = new ArrayList<Conteudo>();
	
	
	public Disciplina(long idDisciplina, String nome) {
		super();
		this.idDisciplina = idDisciplina;
		this.nome = nome;
	}
	
	public Disciplina() {
	}
	
	public long getidDisciplina() {
		return idDisciplina;
	}
	public void setidDisciplina(long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Conteudo> getConteudos() {
		return conteudos;
	}
	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
	
	public void addConteudo(Conteudo produto)
	{
		conteudos.add(produto);	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nome=" + nome + "]";
	}
}
