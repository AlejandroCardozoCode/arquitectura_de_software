package ServicioDB;

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
public class ServiciosUsuario implements ServiciosUsuarioRemote, ServiciosUsuarioLocal {
	
	@PersistenceContext (unitName="UsuarioUP" , type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public ServiciosUsuario() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public List<Usuario> findUsuario(String userName, String password) {
		String consulta = "SELECT nombre FROM usuario ";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		query.setMaxResults(1);
		List<Usuario> resultList = query.getResultList();
		return resultList;
    }

	@Override
	public String addUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
