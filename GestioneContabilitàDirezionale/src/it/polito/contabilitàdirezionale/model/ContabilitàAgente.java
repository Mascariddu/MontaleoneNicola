package it.polito.contabilitàdirezionale.model;

public class ContabilitàAgente {
	private int id;
	private String name;
	private int installazioni;
	private float tot_inst;
	private int tot_man_str;
	private float totale;
	private int ricambi;
	private float tot_ricambi;
	private int accessori;
	private float tot_accessori;
	private int manodopera;
	private float tot_manodopera;
	private int costomanodopera;
	private float tot_costomanodopera;
	private int lifo;
	private float tot_lifo;
	private int man_ord_reale;
	private float tot_man_ord_reale;
	private int man_ord_pot;
	private float tot_man_ord_pot;
	private int man_str_Tyfon;
	private int man_straordinaria_ritorni;
	private int man_ritorni_ordninaria;
	private int man_ordn_tyfon;

	public ContabilitàAgente(int id, String name, int installazioni, float tot_inst, int tot_man_str, float totale,
			int ricambi, float tot_ricambi, int accessori, float tot_accessori, int manodopera, float tot_manodopera,
			int costomanodopera, float tot_costomanodopera, int lifo, float tot_lifo, int man_ord_reale,
			float tot_man_ord_reale, int man_ord_pot, float tot_man_ord_pot, int man_str_Tyfon,
			int man_straordinaria_ritorni, int man_ritorni_ordninaria, int man_ordn_tyfon) {
		super();
		this.id = id;
		this.name = name;
		this.installazioni = installazioni;
		this.tot_inst = tot_inst;
		this.tot_man_str = tot_man_str;
		this.totale = totale;
		this.ricambi = ricambi;
		this.tot_ricambi = tot_ricambi;
		this.accessori = accessori;
		this.tot_accessori = tot_accessori;
		this.manodopera = manodopera;
		this.tot_manodopera = tot_manodopera;
		this.costomanodopera = costomanodopera;
		this.tot_costomanodopera = tot_costomanodopera;
		this.lifo = lifo;
		this.tot_lifo = tot_lifo;
		this.man_ord_reale = man_ord_reale;
		this.tot_man_ord_reale = tot_man_ord_reale;
		this.man_ord_pot = man_ord_pot;
		this.tot_man_ord_pot = tot_man_ord_pot;
		this.man_str_Tyfon = man_str_Tyfon;
		this.man_straordinaria_ritorni = man_straordinaria_ritorni;
		this.man_ritorni_ordninaria = man_ritorni_ordninaria;
		this.man_ordn_tyfon = man_ordn_tyfon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ContabilitàAgente other = (ContabilitàAgente) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInstallazioni() {
		return installazioni;
	}

	public void setInstallazioni(int installazioni) {
		this.installazioni = installazioni;
	}

	public float getTot_inst() {
		return tot_inst;
	}

	public void setTot_inst(float tot_inst) {
		this.tot_inst = tot_inst;
	}

	public int getTot_man_str() {
		return tot_man_str;
	}

	public void setTot_man_str(int tot_man_str) {
		this.tot_man_str = tot_man_str;
	}

	public float getTotale() {
		return totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
	}

	public int getRicambi() {
		return ricambi;
	}

	public void setRicambi(int ricambi) {
		this.ricambi = ricambi;
	}

	public float getTot_ricambi() {
		return tot_ricambi;
	}

	public void setTot_ricambi(float tot_ricambi) {
		this.tot_ricambi = tot_ricambi;
	}

	public int getAccessori() {
		return accessori;
	}

	public void setAccessori(int accessori) {
		this.accessori = accessori;
	}

	public float getTot_accessori() {
		return tot_accessori;
	}

	public void setTot_accessori(float tot_accessori) {
		this.tot_accessori = tot_accessori;
	}

	public int getManodopera() {
		return manodopera;
	}

	public void setManodopera(int manodopera) {
		this.manodopera = manodopera;
	}

	public float getTot_manodopera() {
		return tot_manodopera;
	}

	public void setTot_manodopera(float tot_manodopera) {
		this.tot_manodopera = tot_manodopera;
	}

	public int getCostomanodopera() {
		return costomanodopera;
	}

	public void setCostomanodopera(int costomanodopera) {
		this.costomanodopera = costomanodopera;
	}

	public float getTot_costomanodopera() {
		return tot_costomanodopera;
	}

	public void setTot_costomanodopera(float tot_costomanodopera) {
		this.tot_costomanodopera = tot_costomanodopera;
	}

	public int getLifo() {
		return lifo;
	}

	public void setLifo(int lifo) {
		this.lifo = lifo;
	}

	public float getTot_lifo() {
		return tot_lifo;
	}

	public void setTot_lifo(float tot_lifo) {
		this.tot_lifo = tot_lifo;
	}

	public int getMan_ord_reale() {
		return man_ord_reale;
	}

	public void setMan_ord_reale(int man_ord_reale) {
		this.man_ord_reale = man_ord_reale;
	}

	public float getTot_man_ord_reale() {
		return tot_man_ord_reale;
	}

	public void setTot_man_ord_reale(float tot_man_ord_reale) {
		this.tot_man_ord_reale = tot_man_ord_reale;
	}

	public int getMan_ord_pot() {
		return man_ord_pot;
	}

	public void setMan_ord_pot(int man_ord_pot) {
		this.man_ord_pot = man_ord_pot;
	}

	public float getTot_man_ord_pot() {
		return tot_man_ord_pot;
	}

	public void setTot_man_ord_pot(float tot_man_ord_pot) {
		this.tot_man_ord_pot = tot_man_ord_pot;
	}

	public int getMan_str_Tyfon() {
		return man_str_Tyfon;
	}

	public void setMan_str_Tyfon(int man_str_Tyfon) {
		this.man_str_Tyfon = man_str_Tyfon;
	}

	public int getMan_straordinaria_ritorni() {
		return man_straordinaria_ritorni;
	}

	public void setMan_straordinaria_ritorni(int man_straordinaria_ritorni) {
		this.man_straordinaria_ritorni = man_straordinaria_ritorni;
	}

	public int getMan_ritorni_ordninaria() {
		return man_ritorni_ordninaria;
	}

	public void setMan_ritorni_ordninaria(int man_ritorni_ordninaria) {
		this.man_ritorni_ordninaria = man_ritorni_ordninaria;
	}

	public int getMan_ordn_tyfon() {
		return man_ordn_tyfon;
	}

	public void setMan_ordn_tyfon(int man_ordn_tyfon) {
		this.man_ordn_tyfon = man_ordn_tyfon;
	}



}
