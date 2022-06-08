package br.com.exemplo.model;

public class DadosPessoais {
	
	private String campus;
	private String cel;
	private String cpf;
	private String curso;
	private String dataNasc;
	private String email;
	private String endereco;
	private int id;
	private String municipio;
	private String nome;
	private String periodo;
	private int rgm;
	private String uf;
	
	
	
	
	
	public DadosPessoais() {
		
	}

	

	public DadosPessoais(String campus, String cel, String cpf, String curso, String dataNasc, String email,
			String endereco, int id, String municipio, String nome, String periodo, int rgm, String uf) {
		super();
		this.campus = campus;
		this.cel = cel;
		this.cpf = cpf;
		this.curso = curso;
		this.dataNasc = dataNasc;
		this.email = email;
		this.endereco = endereco;
		this.id = id;
		this.municipio = municipio;
		this.nome = nome;
		this.periodo = periodo;
		this.rgm = rgm;
		this.uf = uf;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getMinicipio() {
		return municipio;
	}

	public void setMinicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
}
