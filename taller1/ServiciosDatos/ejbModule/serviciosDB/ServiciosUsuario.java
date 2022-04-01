package serviciosDB;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import model.Usuario;

/**
 * Session Bean implementation class ServiciosUsuario
 */
@Stateless
@LocalBean
public class ServiciosUsuario implements ServiciosUsuarioRemote {
	@PersistenceContext(unitName="EntidadesPU", type = PersistenceContextType.TRANSACTION)  
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ServiciosUsuario() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public List<Usuario> findUsuario(String userName, String password) {
		String consulta = "SELECT u FROM usuario u WHERE u.username=:userName AND u.password=:password";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		query.setMaxResults(1);
		List<Usuario> resultList = query.getResultList();
		return resultList;
    }
}
