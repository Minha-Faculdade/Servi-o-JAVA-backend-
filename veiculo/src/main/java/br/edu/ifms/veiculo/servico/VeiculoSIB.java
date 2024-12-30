package br.edu.ifms.veiculo.servico;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.veiculo.dao.VeiculoDao;
import br.edu.ifms.veiculo.dao.VeiculoImpl;
import br.edu.ifms.veiculo.modelo.Veiculo;
import br.edu.ifms.veiculo.util.Conexao;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.edu.ifms.veiculo.servico.VeiculoSEI")
public class VeiculoSIB implements VeiculoSEI{ 
	


	@Override
	public long adicionar(Veiculo veiculo) {
		Connection con = Conexao.getConnection(); 
		VeiculoDao dao = new VeiculoImpl(con);
		long id = 0;
        try {
        	id = dao.adicionar(veiculo);
        	return id;
        } catch (SQLException e) {
            e.printStackTrace();           
        }
        return id;
	}

	@Override
	public Veiculo alterar(Veiculo veiculo) {
		Connection con = Conexao.getConnection(); 
		VeiculoDao dao = new VeiculoImpl(con);
		Veiculo not = null;
        try {
        	not = dao.alterar(veiculo);
        	return not;
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return not;
	}

	@Override
	public boolean apagar(long id) {
		Connection con = Conexao.getConnection(); 
		VeiculoDao dao = new VeiculoImpl(con);
        try {
            return dao.apagar(id);
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return false;
	}

	@Override
	public List<Veiculo> listar() {
		Connection con = Conexao.getConnection(); 
		VeiculoDao dao = new VeiculoImpl(con);
		List<Veiculo> veiculos = new ArrayList<Veiculo>();
        try {
        	veiculos = dao.listar();
            return veiculos;
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return veiculos;
	}

	@Override
	public Veiculo ler(long id) {
		Connection con = Conexao.getConnection(); 
		VeiculoDao dao = new VeiculoImpl(con);
		Veiculo not = null;
        try {
        	not = dao.ler(id);
            return not;
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return not;
	}

}

