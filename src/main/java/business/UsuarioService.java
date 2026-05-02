package business;

import business.converter.UsuarioConverter;
import business.dto.UsuarioDTO;
import com.javanauta.usuario.entity.Usuario;
import com.javanauta.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService{
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
       // usuario = usuarioRepository.save(usuario);
        return usuarioConverter.paraUsuarioDTO
                (usuarioRepository.save(usuario));

    }
}
