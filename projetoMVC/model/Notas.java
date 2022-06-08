package br.com.exemplo.model;

public class Notas {
private int idNotas;
private int rgm;
private String disciplina;
private String semestre;
private String nota;
private String faltas;


public Notas() {}


public Notas(int idNotas, String disciplina, String semestre, String nota, String faltas) {
	this.idNotas = idNotas;
	//this.rgm = rgm;
	this.disciplina = disciplina;
	this.semestre = semestre;
	this.nota = nota;
	this.faltas = faltas;
}
public int getIdNotas() {
	return idNotas;
}


public void setIdNotas(int idNotas) {
	this.idNotas = idNotas;
}


public int getRgm() {
	return rgm;
}


public void setRgm(int rgm) {
	this.rgm = rgm;
}


public String getDisciplina() {
	return disciplina;
}


public void setDisciplina(String disciplina) {
	this.disciplina = disciplina;
}


public String getSemestre() {
	return semestre;
}


public void setSemestre(String semestre) {
	this.semestre = semestre;
}


public String getNota() {
	return nota;
}


public void setNota(String nota) {
	this.nota = nota;
}


public String getFaltas() {
	return faltas;
}


public void setFaltas(String faltas) {
	this.faltas = faltas;
}

}

