package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Conteudo;
import sistema.service.ConteudoService;

@ManagedBean
@ViewScoped
public class ConteudoManagedBean {

	private Conteudo conteudo = new Conteudo();
	private List<Conteudo> conteudos;
	private ConteudoService service = new ConteudoService();

	// Edição de um conteudo na tabela
	public void onRowEdit(RowEditEvent event) {

		Conteudo a = ((Conteudo) event.getObject());
		service.alterar(a);
	}

	public void salvar() {
		conteudo = service.salvar(conteudo);

		if (conteudos != null)
			conteudos.add(conteudo);

		conteudo = new Conteudo();

	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	// Retorna a lista de conteudos para a tabela
	public List<Conteudo> getConteudos() {
		if (conteudos == null)
			conteudos = service.getConteudos();

		return conteudos;
	}

	public void remover(Conteudo conteudo) {
		service.remover(conteudo);
		conteudos.remove(conteudo);

	}

}
