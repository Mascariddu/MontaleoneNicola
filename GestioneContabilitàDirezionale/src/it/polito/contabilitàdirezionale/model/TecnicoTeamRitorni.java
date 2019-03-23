package it.polito.contabilitàdirezionale.model;

public class TecnicoTeamRitorni {
private int id1;
private String nome1;
private int id2;
private String nome2;
private int ritorni;
public TecnicoTeamRitorni(int id1, String nome1, int id2, String nome2, int ritorni) {
	super();
	this.id1 = id1;
	this.nome1 = nome1;
	this.id2 = id2;
	this.nome2 = nome2;
	this.ritorni = ritorni;
}
public int getId1() {
	return id1;
}
public void setId1(int id1) {
	this.id1 = id1;
}
public String getNome1() {
	return nome1;
}
public void setNome1(String nome1) {
	this.nome1 = nome1;
}
public int getId2() {
	return id2;
}
public void setId2(int id2) {
	this.id2 = id2;
}
public String getNome2() {
	return nome2;
}
public void setNome2(String nome2) {
	this.nome2 = nome2;
}
public int getRitorni() {
	return ritorni;
}
public void setRitorni(int ritorni) {
	this.ritorni = ritorni;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id1;
	result = prime * result + id2;
	result = prime * result + ((nome1 == null) ? 0 : nome1.hashCode());
	result = prime * result + ((nome2 == null) ? 0 : nome2.hashCode());
	result = prime * result + ritorni;
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
	TecnicoTeamRitorni other = (TecnicoTeamRitorni) obj;
	if (id1 != other.id1)
		return false;
	if (id2 != other.id2)
		return false;
	if (nome1 == null) {
		if (other.nome1 != null)
			return false;
	} else if (!nome1.equals(other.nome1))
		return false;
	if (nome2 == null) {
		if (other.nome2 != null)
			return false;
	} else if (!nome2.equals(other.nome2))
		return false;
	if (ritorni != other.ritorni)
		return false;
	return true;
}


}
