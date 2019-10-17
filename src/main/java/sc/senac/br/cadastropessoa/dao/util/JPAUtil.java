package sc.senac.br.cadastropessoa.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private final static EntityManagerFactory factory;
	
	static {
		factory = Persistence
			.createEntityManagerFactory("CadastroPessoasPU");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
}
