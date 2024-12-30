 package br.edu.ifms.veiculo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.veiculo.modelo.Veiculo;

public class VeiculoImpl implements VeiculoDao {

	private Connection connection;

	public VeiculoImpl(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public long adicionar(Veiculo veiculo) throws SQLException {
		Statement stmt = null;
		long id = 0;
		try {
			String sql = "insert into veiculo (modelo, marca, cor)"+
					" values (\'"+veiculo.getModelo()+"\',\'"+veiculo.getMarca()+"\',\'"+ veiculo.getCor()+"\') RETURNING ID";
			stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				id = rs.getLong(1);
	        }			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return id;
	}

	@Override
	public Veiculo alterar(Veiculo veiculo) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "update veiculo set modelo = ? , marca= ? , cor= ? "
					   + "where id = ? ;";
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, veiculo.getModelo());		
			stmt.setString(2, veiculo.getMarca());
			stmt.setString(3, veiculo.getCor());
			stmt.setLong(4, veiculo.getId());
			stmt.execute();			
			return ler(veiculo.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			stmt.close();
		}
		return null;
	}

	@Override
	public boolean apagar(long id) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = "delete from veiculo where id = ? ;";
			stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.execute();			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			stmt.close();
		}
		return false;
	}

	@Override
	public List<Veiculo> listar() throws SQLException {
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		Statement stmt = null;
		try {
			String sql = "select * from veiculo";
			stmt = this.connection.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);		    
		    while (rs.next()) {
		    	Veiculo not = new Veiculo();
	            not.setId(rs.getLong("id"));
	            not.setModelo(rs.getString("Modelo"));
	            not.setMarca(rs.getString("Marca"));
	            not.setCor(rs.getString("Cor"));
	            veiculos.add(not);
	        }			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			stmt.close();
		}
		return veiculos;
	}

	@Override
	public Veiculo ler(long id) throws SQLException {
		Statement stmt = null;		 
        Veiculo not = null;        
        try {
        	String sql = "select * from veiculo where id = " + id;
        	stmt = this.connection.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);		    
		    if (rs.next()) {
	            not = new Veiculo();
                not.setId(rs.getLong("id"));
                not.setModelo(rs.getString("Modelo"));
                not.setMarca(rs.getString("Marca"));
                not.setCor(rs.getString("Cor"));
	        }			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			stmt.close();
		}       
        return not;
	}

}
