package br.com.exemplo.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.model.Notas;
import br.com.exemplo.ultil.ConnectionFactory;


public class MVCNdao {
	private Notas notas;
	private Connection con;
	private java.sql.PreparedStatement ps;
	private ResultSet rs;
	
	public  MVCNdao() throws Exception {
		try {
			con=ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro ao acessar"+e.getMessage());
		}
	}
	public void salvar(Notas notas) throws Exception{
		try{
			String sql="INSERT INTO notas(idNotas,rgm,disciplina,semestre, nota, faltas)"+"VALUES(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, notas.getIdNotas());
			ps.setInt(2, notas.getRgm());
			ps.setString(3, notas.getDisciplina());
			ps.setString(4, notas.getSemestre());
			ps.setString(5, notas.getNota());
			ps.setString(6, notas.getFaltas());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao salvar!"+e.getMessage());
		}
	}
	public void alterar(Notas notas) throws Exception{
		try {
				String sql="UPDATE notas SET disciplina=?,semestre=?,nota=?,faltas=? WHERE rgm=?";
				ps=con.prepareStatement(sql);
				//ps.setInt	(1, notas.getRgm());
				ps.setString(1, notas.getDisciplina());
				ps.setString(2, notas.getSemestre());
				ps.setString(3, notas.getNota());
				ps.setString(4, notas.getFaltas());
				ps.setInt(5, notas.getRgm());
				ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao alterar!"+e.getMessage());
		}
	}
	public void deletar(int rgm) throws Exception{
		try {
				String sql="DELETE FROM notas WHERE rgm=?";
				ps=con.prepareStatement(sql);
				ps.setInt(1, rgm);
				ps.executeUpdate();
		} catch(Exception e) {
			throw new Exception("Erro ao excluir!"+e.getMessage());
		}
	}
	public List<Notas> todos() throws Exception{
		List<Notas>lista=new ArrayList<Notas>();
		try {
			ps=con.prepareStatement("SELECT*FROM notas");
			rs=ps.executeQuery();
			while(rs.next()) {
				int idNotas=rs.getInt("idNotas");
				String disciplina=rs.getString("disciplina");
				String semestre=rs.getString("Semestre");
				String nota=rs.getString("nota");
				String faltas=rs.getString("faltas");
				notas=new Notas(idNotas,disciplina,semestre,nota,faltas); 
				lista.add(notas);
			}
			return lista;
		}catch(Exception e) {
			throw new Exception("Erro ao listar!"+e.getMessage());
		}
	}
	public Notas consultar(int rgm) throws Exception{
	try {
		ps=con.prepareStatement("SELECT*FROM notas WHERE rgm=?");
		ps.setInt(1, rgm);
		rs=ps.executeQuery();
		if(rs.next()) {
			int idNotas=rs.getInt("idNotas");
			String disciplina=rs.getString("disciplina");
			String semestre=rs.getString("Semestre");
			String nota=rs.getString("nota");
			String faltas=rs.getString("faltas");
			notas=new Notas(idNotas,disciplina,semestre,nota,faltas);
				
		}return notas;
	}catch(Exception e) {
		throw new Exception("Erro ao consultar!"+e.getMessage());
	}
	
	}
}
