package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class VerdadeiroFalso implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int matricula;
	
	private String nome;
	private String resposta;
	
	@ManyToMany
	private ArrayList<Pergunta> Perguntas = new ArrayList<Pergunta>();
	
	public ArrayList<Pergunta> getPerguntas() {
		return Perguntas;
	}
	public void setPerguntas(ArrayList<Pergunta> perguntas) {
		Perguntas = perguntas;
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
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
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
		VerdadeiroFalso other = (VerdadeiroFalso) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "VerdadeiroFalso [matricula=" + matricula + ", nome=" + nome + ", resposta=" + resposta + "]";
	}

}
