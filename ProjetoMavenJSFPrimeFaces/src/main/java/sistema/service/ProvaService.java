package sistema.service;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.ProvaDAO;
import sistema.modelos.Prova;


public class ProvaService {

 	ProvaDAO provaDAO = new ProvaDAO();
 	
	public Prova salvar(Prova prova)
	{
		prova = provaDAO.save(prova);
		provaDAO.closeEntityManager();
		return prova;
		
	}
	
	public List <Prova> getProvas()
	{
		List <Prova> list = provaDAO.getAll(Prova.class);
		List<Prova> aux = new ArrayList<Prova>();
		for(Prova x : list)
		{
			if (x.getNome() != "")
			{
				aux.add(x);
			}
				
		}
		provaDAO.closeEntityManager();
		return aux;
	}

	public void alterar(Prova prova) {
		provaDAO.save(prova);
		provaDAO.closeEntityManager();
	}

	
	public void remover(Prova prova) {
		
		prova = provaDAO.getById(Prova.class, prova.getIdProva());
		provaDAO.remove(prova);
		provaDAO.closeEntityManager();
	}
	
}
