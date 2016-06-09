package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.VerdadeiroFalsoDAO;
import sistema.modelos.VerdadeiroFalso;


public class VerdadeiroFalsoService {

 	VerdadeiroFalsoDAO verdadeiroFalsoDAO = new VerdadeiroFalsoDAO();
 	
	public VerdadeiroFalso salvar(VerdadeiroFalso verdadeiroFalso)
	{
		verdadeiroFalso = verdadeiroFalsoDAO.save(verdadeiroFalso);
		verdadeiroFalsoDAO.closeEntityManager();
		return verdadeiroFalso;
		
	}
	
	public List <VerdadeiroFalso> getVerdadeiroFalsos()
	{
		List <VerdadeiroFalso> list = verdadeiroFalsoDAO.getAll(VerdadeiroFalso.class);
		verdadeiroFalsoDAO.closeEntityManager();
		return list;
	}

	public void alterar(VerdadeiroFalso verdadeiroFalso) {
		verdadeiroFalsoDAO.save(verdadeiroFalso);
		verdadeiroFalsoDAO.closeEntityManager();
	}

	
	public void remover(VerdadeiroFalso verdadeiroFalso) {
		
		verdadeiroFalso = verdadeiroFalsoDAO.getById(VerdadeiroFalso.class, verdadeiroFalso.getMatricula());
		verdadeiroFalsoDAO.remove(verdadeiroFalso);
		verdadeiroFalsoDAO.closeEntityManager();
	}
	
}
