package entidades;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import excessoes.DadosAbertosException;

public class Acidente<E>  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer feridos;
	private Integer vitimasFatais;
	private Integer qtdAutomoveis;
	private Integer qtdMotocicletas;
	private String id;
	private String logradouro;
	private String tipoAcidente;
	private String momentoDoDia;
	
	private Map<Integer, E> campos = new HashMap<>();
	
	
	public Acidente() {
	}

	public Acidente(Integer feridos, Integer vitimasFatais, Integer qtdAutomoveis, Integer qtdMotocicletas, String id,
			String logradouro, String tipoAcidente, String momentoDoDia) {
		this.feridos = feridos;
		this.vitimasFatais = vitimasFatais;
		this.qtdAutomoveis = qtdAutomoveis;
		this.qtdMotocicletas = qtdMotocicletas;
		this.id = id;
		this.logradouro = logradouro;
		this.tipoAcidente = tipoAcidente;
		this.momentoDoDia = momentoDoDia;
		
		
	}

	public Integer getFeridos() {
		return feridos;
	}

	public void setFeridos(Integer feridos) {
		this.feridos = feridos;
	}

	public Integer getVitimasFatais() {
		return vitimasFatais;
	}

	public void setVitimasFatais(Integer vitimasFatais) {
		this.vitimasFatais = vitimasFatais;
	}

	public Integer getQtdAutomoveis() {
		return qtdAutomoveis;
	}

	public void setQtdAutomoveis(Integer qtdAutomoveis) {
		this.qtdAutomoveis = qtdAutomoveis;
	}

	public Integer getQtdMotocicletas() {
		return qtdMotocicletas;
	}

	public void setQtdMotocicletas(Integer qtdMotocicletas) {
		this.qtdMotocicletas = qtdMotocicletas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getTipoAcidente() {
		return tipoAcidente;
	}

	public void setTipoAcidente(String tipoAcidente) {
		this.tipoAcidente = tipoAcidente;
	}

	public String getMomentoDoDia() {
		return momentoDoDia;
	}

	public void setMomentoDoDia(String momentoDoDia) {
		this.momentoDoDia = momentoDoDia;
	}
	
	public String buscaCampos(Integer i) {
		iniciaCampos();
		
		if(i == 1) {
			return "Feridos: " + campos.get(i);
		}
		else if(i == 2) {
			return "Vitimas fatais: " + campos.get(i);
		}
		else if(i == 3) {
			return "Automoveis envolvidos : " + campos.get(i);
		}
		else if(i == 4) {
			return "Motocicletas envolvidas: " + campos.get(i);
		}
		else if(i == 5) {
			return "Identificador: " + campos.get(i);
		}
		else if(i == 6) {
			return "Logradouro: " + campos.get(i);
		}
		else if(i == 7) {
			return "Tipo do acidente: " + campos.get(i);
		}
		else if(i == 8) {
			return "Momento do dia: " + campos.get(i);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private void iniciaCampos() {
		campos.put(1, (E)getFeridos());
		campos.put(2, (E)getVitimasFatais());
		campos.put(3, (E)getQtdAutomoveis());
		campos.put(4, (E)getQtdMotocicletas());
		campos.put(5, (E)getId());
		campos.put(6, (E)getLogradouro());
		campos.put(7, (E)getTipoAcidente());
		campos.put(8, (E)getMomentoDoDia());
	}

	@Override
	public String toString() {
		return "feridos=" + feridos + "; vitimasFatais=" + vitimasFatais + "; qtdAutomoveis=" + qtdAutomoveis
				+ "; qtdMotocicletas=" + qtdMotocicletas + "; id=" + id + "; logradouro=" + logradouro
				+ "; tipoAcidente=" + tipoAcidente + "; momentoDoDia=" + momentoDoDia;
	}
	
	
}
