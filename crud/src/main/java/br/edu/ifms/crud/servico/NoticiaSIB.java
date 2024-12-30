package br.edu.ifms.crud.servico;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifms.crud.dao.NoticiaDao;
import br.edu.ifms.crud.dao.NoticiaImpl;
import br.edu.ifms.crud.modelo.Noticia;
import br.edu.ifms.crud.util.Conexao;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.edu.ifms.crud.servico.NoticiaSEI")
public class NoticiaSIB implements NoticiaSEI{
	


	@Override
	public long adicionar(Noticia noticia) {
		Connection con = Conexao.getConnection(); 
		NoticiaDao dao = new NoticiaImpl(con);
		long id = 0;
        try {
        	id = dao.adicionar(noticia);
        	return id;
        } catch (SQLException e) {
            e.printStackTrace();           
        }
        return id;
	}

	@Override
	public Noticia alterar(Noticia noticia) {
		Connection con = Conexao.getConnection(); 
		NoticiaDao dao = new NoticiaImpl(con);
		Noticia not = null;
        try {
        	not = dao.alterar(noticia);
        	return not;
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return not;
	}

	@Override
	public boolean apagar(long id) {
		Connection con = Conexao.getConnection(); 
		NoticiaDao dao = new NoticiaImpl(con);
        try {
            return dao.apagar(id);
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return false;
	}

	@Override
	public List<Noticia> listar() {
		Connection con = Conexao.getConnection(); 
		NoticiaDao dao = new NoticiaImpl(con);
		List<Noticia> noticias = new ArrayList<Noticia>();
        try {
        	noticias = dao.listar();
            return noticias;
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return noticias;
	}

	@Override
	public Noticia ler(long id) {
		Connection con = Conexao.getConnection(); 
		NoticiaDao dao = new NoticiaImpl(con);
		Noticia not = null;
        try {
        	not = dao.ler(id);
            return not;
        } catch (SQLException e) {
            e.printStackTrace();            
        }
        return not;
	}

}

