package me.thiagoAfonso.SGRH.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.thiagoAfonso.SGRH.model.Empregado;


public class EmpregadoJdbcDAO {

	private Connection conn;

	public EmpregadoJdbcDAO(Connection conn) {
		this.conn = conn;
	}

	public void salvar(Empregado e) throws SQLException {
		String sql = "insert into alunos (nome, sobrenome, cpf) values ('" + e.getNome() + "','" + e.getSobrenome()
				+ "','" + e.getCPF() + "')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	
	public List<Empregado> listar() {
		String sql = "select * from alunos";
        System.out.println(sql);		
        List<Empregado> Empregado = new ArrayList<Empregado>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {				
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");				
				Empregado aluno = new Empregado();				
				aluno.setNome(nome);
				aluno.setSobrenome(sobrenome);
				aluno.setCPF(cpf);
				
				System.out.println();
				
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Empregado;
	}
}