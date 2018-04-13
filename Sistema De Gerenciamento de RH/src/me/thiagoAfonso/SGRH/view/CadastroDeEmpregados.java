package me.thiagoAfonso.SGRH.view;
import java.sql.Connection;
import java.sql.SQLException;

import me.thiagoAfonso.SGRH.model.Empregado;
import me.thiagoAfonso.SGRH.persistence.EmpregadoJdbcDAO;
import me.thiagoAfonso.SGRH.persistence.JdbcUtil;



public class CadastroDeEmpregados {
	public static void main(String args[]) throws SQLException, ClassNotFoundException {
		Empregado empregado = new Empregado();
		empregado.setNome("Thiago");
		empregado.setSobrenome("Afonso");
		empregado.setCPF("123.456.789-101");
		Connection connection = JdbcUtil.getConexao();
		EmpregadoJdbcDAO tt = new EmpregadoJdbcDAO(connection);
		tt.salvar(empregado);
		System.out.println(tt.listar().toString());
	}	
}