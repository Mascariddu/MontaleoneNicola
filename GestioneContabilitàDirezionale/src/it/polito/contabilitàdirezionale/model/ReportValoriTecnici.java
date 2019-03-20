package it.polito.contabilitàdirezionale.model;

public class ReportValoriTecnici {
private int id;
private String nome;
private double tot_fat;
private int ric_str_vs_app;
private float man_str_vs_app;
private float margine;
private float asp_ricevuta;
private float asp_ricevuta_vs_app;
private float incidenza_ritorni;
public ReportValoriTecnici(int id, String nome, double tot_fat, int ric_str_vs_app, float man_str_vs_app, float margine,
		float asp_ricevuta, float asp_ricevuta_vs_app, float incidenza_ritorni) {
	super();
	this.id = id;
	this.nome = nome;
	this.tot_fat = tot_fat;
	this.ric_str_vs_app = ric_str_vs_app;
	this.man_str_vs_app = man_str_vs_app;
	this.margine = margine;
	this.asp_ricevuta = asp_ricevuta;
	this.asp_ricevuta_vs_app = asp_ricevuta_vs_app;
	this.incidenza_ritorni = incidenza_ritorni;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getTot_fat() {
	return tot_fat;
}
public void setTot_fat(double tot_fat) {
	this.tot_fat = tot_fat;
}
public int getRic_str_vs_app() {
	return ric_str_vs_app;
}
public void setRic_str_vs_app(int ric_str_vs_app) {
	this.ric_str_vs_app = ric_str_vs_app;
}
public float getMan_str_vs_app() {
	return man_str_vs_app;
}
public void setMan_str_vs_app(float man_str_vs_app) {
	this.man_str_vs_app = man_str_vs_app;
}
public float getMargine() {
	return margine;
}
public void setMargine(float margine) {
	this.margine = margine;
}
public float getAsp_ricevuta() {
	return asp_ricevuta;
}
public void setAsp_ricevuta(float asp_ricevuta) {
	this.asp_ricevuta = asp_ricevuta;
}
public float getAsp_ricevuta_vs_app() {
	return asp_ricevuta_vs_app;
}
public void setAsp_ricevuta_vs_app(float asp_ricevuta_vs_app) {
	this.asp_ricevuta_vs_app = asp_ricevuta_vs_app;
}
public float getIncidenza_ritorni() {
	return incidenza_ritorni;
}
public void setIncidenza_ritorni(float incidenza_ritorni) {
	this.incidenza_ritorni = incidenza_ritorni;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ReportValoriTecnici other = (ReportValoriTecnici) obj;
	if (id != other.id)
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	return true;
}


}

