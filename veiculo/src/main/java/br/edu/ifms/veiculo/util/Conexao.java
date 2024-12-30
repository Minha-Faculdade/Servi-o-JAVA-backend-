package br.edu.ifms.veiculo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static final Connection connection = construirConexao();

	private static Connection construirConexao() {
		try {			
			Class.forName("org.postgresql.Driver");			
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/veiculo", "postgres",
					"postgres");

		} catch (Exception ex) {
			System.err.println("Conexao falhou: " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	public static Connection getConnection() {
		return connection;
	}
}
