package org.itstep.javaee.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.itstep.javaee.dao.DBConnect;
import org.itstep.javaee.dao.UsuarioDao;
import org.itstep.javaee.dao.exception.DaoException;
import org.itstep.javaee.modelo.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario create(Usuario usuario) throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "insert into usuario (nome, cpf, email, endereco) values (?, ?,?,?)";
		try {
			PreparedStatement comandoJdbc = conexaoBD.prepareStatement(comandoSql);
			comandoJdbc.setString(1, usuario.getName());
			comandoJdbc.setString(2, usuario.getCpf());
			comandoJdbc.setString(3, usuario.getEmail());
			comandoJdbc.setString(4, usuario.getEndereco());
			comandoJdbc.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Inclusão do usuario falhou.", e);
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conexão com o banco de dados falhou.", e);
			}
		}
		return usuario;
	}

	@Override
	public List<Usuario> findByAll() throws DaoException {
		// TODO Auto-generated method stub

		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "select nome, cpf, email, endereco from usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement comandoJdbc = conexaoBD.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = comandoJdbc.executeQuery(comandoSql);
			while (rs.next()) {
				usuarios.add(new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			throw new DaoException("Inclusão do usuario falhou.", e);
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conexão com o banco de dados falhou.", e);
			}
		}
		return usuarios;
	}

}
