package py.com.cvs2.converters;

import py.com.cvs2.dto.UsuarioRolDto;
import py.com.cvs2.model.UsuarioRol;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRolDtoConverter {

    public UsuarioRolDto converter(UsuarioRol usuarioRol) {
        UsuarioRolDto usuarioRolDto = new UsuarioRolDto();

        usuarioRolDto.setId(usuarioRol.getId());
        usuarioRolDto.setUsuario(usuarioRol.getUsuario());
        usuarioRolDto.setRol(usuarioRol.getRol());
        usuarioRolDto.setEstado(usuarioRol.getEstado());

        //usuarioRolDto.setPermisos(usuarioRolDto.getPermisos());

        return usuarioRolDto;
    }

    public List<UsuarioRolDto> converter(List<UsuarioRol> usuarioRolList) {
        List<UsuarioRolDto> usuarioRolDtoList = new ArrayList<>();

        for(UsuarioRol usuarioRol : usuarioRolList){
            usuarioRolDtoList.add(converter(usuarioRol));
        }

        return usuarioRolDtoList;
    }


}
