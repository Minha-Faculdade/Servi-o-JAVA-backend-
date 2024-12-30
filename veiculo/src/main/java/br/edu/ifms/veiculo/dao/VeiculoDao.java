package br.edu.ifms.veiculo.dao;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifms.veiculo.modelo.Veiculo;

public interface VeiculoDao {
	public long adicionar(Veiculo veiculo) throws SQLException;
	public Veiculo alterar(Veiculo veiculo) throws SQLException;
	public boolean apagar(long id) throws SQLException;
	public List<Veiculo> listar() throws SQLException;
	public Veiculo ler(long id) throws SQLException;
}
