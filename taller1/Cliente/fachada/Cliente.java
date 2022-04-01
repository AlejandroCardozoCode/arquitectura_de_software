package fachada;

import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Usuario;
import serviciosDB.ServiciosUsuarioRemote;

public class Cliente {
	public static void main(String[] args) {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "admin");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "admin");
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		Context ctx;
		String namespace = "ejb:";
		String appName = "Ejemplo01";
		String moduleName = "ServiciosDatos";
		String distinctName = "";
		String beanName = "ServiciosUsuario";
		String viewClassName = ServiciosUsuarioRemote.class.getName();
		ServiciosUsuarioRemote seriviciosusuarios = null;
		try {
			ctx = new InitialContext(jndiProperties);
			seriviciosusuarios = (ServiciosUsuarioRemote) ctx.lookup(
					namespace + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Usuario> lista = seriviciosusuarios.getAllUsuarios();
		for (Usuario usuario : lista) {
			System.out.println(usuario.getIdusuario() + ", " + usuario.getNombre());
		}
		System.out.println("Size: " + lista.size());
	}
}
