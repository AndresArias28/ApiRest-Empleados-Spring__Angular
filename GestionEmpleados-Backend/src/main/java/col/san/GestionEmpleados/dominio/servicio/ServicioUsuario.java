//package col.san.GestionEmpleados.dominio.servicio;
//
//import col.san.GestionEmpleados.dominio.Rol;
//import col.san.GestionEmpleados.dominio.Usuario;
//import col.san.GestionEmpleados.infraestructura.persistencia.repositorio.RepositorioUsuarioJPA;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//
//@Service("userDetailsService")//indicar bean de Spring de seguridad
//public class ServicioUsuario implements UserDetailsService {
//
//    @Autowired
//    private RepositorioUsuarioJPA repositorioUsuarioJPA;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario usuario = repositorioUsuarioJPA.findByUsername(username);
//
//        if (usuario == null) throw new UsernameNotFoundException(username);
//
//        var roles = new ArrayList<GrantedAuthority>();
//
//        for(Rol rol: usuario.getRoles()){
//            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
//        }
//
//        return  new User(usuario.getUsername(), usuario.getPassword(), roles);
//
//    }
//}
