package org.itstep.javaee.dao;

import java.util.List;

import org.itstep.javaee.dao.exception.DaoException;

import org.itstep.javaee.modelo.*;

public interface UsuarioDao {
	public Usuario create(Usuario usuario) throws DaoException;
	public List<Usuario> findByAll() throws DaoException;
}
