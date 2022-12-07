package py.com.cvs2.controller;

import org.apache.commons.codec.digest.DigestUtils;

import py.com.cvs2.dao.*;
import py.com.cvs2.dao.UsuarioDao;
import py.com.cvs2.dto.RolPermisoDto;
import py.com.cvs2.dto.TokenDto;
import py.com.cvs2.dto.UsuarioDto;
import py.com.cvs2.dto.UsuarioRolDto;
import py.com.cvs2.model.*;
import py.com.cvs2.model.Usuario;
import py.com.cvs2.util.Configuracion;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {

	public TokenDto validar(Usuario usuario) throws Exception {
		usuario.setClave(DigestUtils.md5Hex(usuario.getClave()));
		UsuarioDao usuariosDAO = new UsuarioDao();
		TokenDto datos = usuariosDAO.validarAcceso(usuario);
		return datos;
	}

	public Usuario getByToken(String token) {
		return Configuracion.getUsuarioJWT(token);
	}

	public List<UsuarioDto> listUsuarios(Boolean all) {
		UsuarioDao usuarioDao = new UsuarioDao();
		UsuarioRolDao usuarioRolDao = new UsuarioRolDao();
		List<Usuario> usuarioList = usuarioDao.list(all);

		List<UsuarioDto> usuarioDtoList = new ArrayList<UsuarioDto>();
		for(Usuario usuario: usuarioList){
			UsuarioDto usuarioDto = new UsuarioDto();
			usuarioDto.setUsuario(usuario);
			usuarioDto.setRoles(new ArrayList<Rol>());
			List<UsuarioRol> roles = usuarioRolDao.listByIdUsuario(usuario.getId());
			for(UsuarioRol usuarioRol: roles){
				usuarioDto.getRoles().add(usuarioRol.getRol());
			}
			usuarioDtoList.add(usuarioDto);
		}

		return usuarioDtoList;
	}

	public List<UsuarioRol> listUsuariosByRol(Integer rolId) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.listByRol(rolId);
	}

	public UsuarioDto getUsuarioById(Integer id) {
		UsuarioDao usuarioDao = new UsuarioDao();
		UsuarioRolDao usuarioRolDao = new UsuarioRolDao();

		Usuario usuario = usuarioDao.findById(id);
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto.setUsuario(usuario);
		usuarioDto.setRoles(new ArrayList<Rol>());
		List<UsuarioRol> usuarioRolList = usuarioRolDao.listByIdUsuario(usuario.getId());
		for(UsuarioRol usuarioRol: usuarioRolList){
			usuarioDto.getRoles().add(usuarioRol.getRol());
		}

		return usuarioDto;
	}

	public UsuarioDto saveUsuario(UsuarioDto usuarioDto) throws Exception {
		UsuarioDao usuarioDao = new UsuarioDao();
		UsuarioRolDao usuarioRolDao = new UsuarioRolDao();

		Usuario usuario = usuarioDto.getUsuario();
		usuario.setEstado("ACTIVO");
		usuario.setClave(DigestUtils.md5Hex(usuario.getClave()));
		usuario.setIntentosFallidos(0);
		usuario = usuarioDao.save(usuario);

		for(Rol rol: usuarioDto.getRoles()){
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setUsuario(usuario);
			usuarioRol.setRol(rol);
			usuarioRol.setEstado("ACTIVO");

			usuarioRolDao.save(usuarioRol);
		}

		return usuarioDto;
	}

	public UsuarioDto updateUsuario(UsuarioDto usuarioDto) throws Exception {
		UsuarioDao usuarioDao = new UsuarioDao();
		UsuarioRolDao usuarioRolDao = new UsuarioRolDao();

		Usuario usuario = usuarioDto.getUsuario();
		usuarioDao.update(usuario);

		List<UsuarioRol> rolesViejos = usuarioRolDao.listByIdUsuario(usuario.getId());
		for(UsuarioRol usuarioRol: rolesViejos){
			usuarioRol.setEstado("INACTIVO");
			usuarioRolDao.update(usuarioRol);
		}

		for(Rol rol : usuarioDto.getRoles()) {
			UsuarioRol usuarioRol = usuarioRolDao.getUsuarioRolByUsuarioAndRol(usuario.getId(), rol.getId());
			if(usuarioRol != null){
				usuarioRol.setEstado("ACTIVO");
				usuarioRolDao.update(usuarioRol);
			} else {
				usuarioRol = new UsuarioRol(usuario, rol);
				usuarioRolDao.save(usuarioRol);
			}
		}

		return usuarioDto;
	}

	public void deleteUsuario(Integer id) throws Exception {
		UsuarioDao usuarioDao = new UsuarioDao();
		UsuarioRolDao usuarioRolDao = new UsuarioRolDao();


		Usuario usuario = usuarioDao.findById(id);
		usuario.setEstado("INACTIVO");
		usuarioDao.update(usuario);

		List<UsuarioRol> roles = usuarioRolDao.listByIdUsuario(usuario.getId());
		for(UsuarioRol usuarioRol: roles){
			usuarioRol.setEstado("INACTIVO");
			usuarioRolDao.update(usuarioRol);
		}
		//usuarioDao.delete(id);
	}

}
