package serviciosDB;

import java.util.List;

import javax.ejb.Remote;

import model.Usuario;

@Remote
public interface ServiciosUsuarioRemote {

	public List<Usuario> getAllUsuarios();

}
