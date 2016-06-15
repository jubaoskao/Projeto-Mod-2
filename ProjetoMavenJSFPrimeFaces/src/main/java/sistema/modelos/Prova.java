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
public class Prova implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProva;
	private String nome;
	private int duracao;
	private int nivelProva;
	private int qtdePerguntas;
	
	public int getQtdePerguntas() {
		return qtdePerguntas;
	}
	public void setQtdePerguntas(int qtdePerguntas) {
		this.qtdePerguntas = qtdePerguntas;
	}
	public int getIdProva() {
		return idProva;
	}
	public void setIdProva(int idProva) {
		this.idProva = idProva;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public int getNivelProva() {
		return nivelProva;
	}
	public void setNivelProva(int nivelProva) {
		this.nivelProva = nivelProva;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProva;
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
		Prova other = (Prova) obj;
		if (idProva != other.idProva)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Prova [idProva=" + idProva + ", nome=" + nome + ", duracao=" + duracao + "]";
	} 
}
