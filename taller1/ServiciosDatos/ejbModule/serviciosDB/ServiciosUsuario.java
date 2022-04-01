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
    public List<Usuario> getAllUsuarios() {
    // TODO Auto-generated method stub
    return entityManager.createQuery("SELECT p FROM usuario p", Usuario.class).getResultList();
    }
}

