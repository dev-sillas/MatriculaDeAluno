package br.com.exemplo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.DadosPessoais;
import br.com.exemplo.ultil.ConnectionFactory;

public class MVCDao {

	private DadosPessoais dados;
	private Connection conn;
	private java.sql.PreparedStatement ps;
	private ResultSet rs;
	
	//metodo contrutor
	public  MVCDao() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();
	}catch(Exception e) {
		throw new Exception("ERROR" +e.getMessage());
	}
}
	//metodo salvar
	public void salvar(DadosPessoais dados)throws Exception {
	try {
		String sql="INSERT INTO dadosaluno(id,cel, cpf, dataNasc, email, endereco, municipio, nomes, rgm, uf,curso,campus,periodo)"
				+ "values (?,?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt	(1, dados.getId());
		ps.setString(2, dados.getCel());
		ps.setString(3, dados.getCpf());
		ps.setString(4, dados.getDataNasc());
		ps.setString(5, dados.getEmail());
		ps.setString(6, dados.getEndereco());
		ps.setString(7, dados.getMinicipio());
		ps.setString(8, dados.getNome());
		ps.setInt	(9, dados.getRgm());
		ps.setString(10,dados.getUf());
		ps.setString(11, dados.getCurso());
		ps.setString(12, dados.getCampus());
		ps.setString(13, dados.getPeriodo());
		ps.executeUpdate();
	}catch(Exception e) {
		throw new Exception(e.getMessage());
	}		
}
	//metodo alterar
	public void alterar(DadosPessoais dados)throws Exception {
	try {
		String sql="UPDATE DadosAluno SET campus=?,cel=?, cpf=?,curso=?,dataNasc=?, email=?, endereco=?, municipio=?, nomes=?, periodo=?,uf=? WHERE rgm=?";
		ps = conn.prepareStatement(sql);
		//ps.setInt   (1, dados.getId());
		ps.setString(1, dados.getCampus());
		ps.setString(2, dados.getCel());
		ps.setString(3, dados.getCpf());
		ps.setString(4, dados.getCurso());
		ps.setString(5, dados.getDataNasc());
		ps.setString(6, dados.getEmail());
		ps.setString(7, dados.getEndereco());
		ps.setString(8, dados.getMinicipio());
		ps.setString(9, dados.getNome());
		ps.setString(10, dados.getPeriodo());
		ps.setString(11, dados.getUf());
		ps.setInt   (12, dados.getRgm());
		ps.executeUpdate();
	}catch(Exception e) {
		throw new Exception("Erro ao atualizar!"+e.getMessage());
		}		
	}
	//metodo excluir
	public void excluir(int rgm)throws Exception {
	try {
		String sql="DELETE FROM DadosAluno WHERE rgm=?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1,rgm);
		ps.executeUpdate();
	}catch(Exception e) {
		throw new Exception("Erro ao excluir!"+e.getMessage());
	}		
}
	//metodo LISTAR todos
	public List DadosPessoaistodos() throws Exception{
		List<DadosPessoais> lista = new ArrayList<DadosPessoais>();
		try {
			ps = conn.prepareStatement("SELECT * FROM DadosAluno");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				int rgm = rs.getInt("rgm");
				String nome =rs.getString("nomes");
				String dataNasc = rs.getString("dataNasc");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				String cel = rs.getString("cel");
				String curso=rs.getString("curso");
				String campus=rs.getString("campus");
				String periodo=rs.getString("periodo");
				dados = new DadosPessoais(campus, cel, cpf, curso, dataNasc, email, endereco, id, municipio, nome, periodo, rgm, uf);
				lista.add(dados);
			}
			return lista;

		}catch(Exception e) {
			throw new Exception("Erro ao listar os dados" +e.getMessage());
		}
	}
	//metodo consultar
	public DadosPessoais consultar(int rgm) throws Exception{
		try {
			String sql="SELECT * FROM DadosAluno WHERE rgm=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");
				String nome =rs.getString("nomes");
				String dataNasc = rs.getString("dataNasc");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String municipio = rs.getString("municipio");
				String uf = rs.getString("uf");
				String cel = rs.getString("cel");
				String curso=rs.getString("curso");
				String campus=rs.getString("campus");
				String periodo=rs.getString("periodo");
				dados = new DadosPessoais(campus, cel, cpf, curso, dataNasc, email, endereco, id, municipio, nome, periodo, rgm, uf);
			}
			return dados;
		}catch(Exception e) {
			throw new Exception("Erro ao listar !" +e.getMessage());
		}
	}
	
}

