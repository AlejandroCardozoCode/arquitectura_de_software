package ServicioDB;

import java.util.List;

import javax.ejb.Remote;

import model.Usuario;

@Remote
public interface ServiciosUsuarioRemote {
	public List<Usuario> findUsuario(String userName, String password);
	public String addUsuario();
	public List<Usuario> getAllUsuarios();
	}
