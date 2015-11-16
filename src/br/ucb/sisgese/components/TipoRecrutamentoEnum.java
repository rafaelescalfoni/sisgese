package br.ucb.sisgese.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum TipoRecrutamentoEnum {
	INTERNO("Interno"),
	EXTERNO("Externo");
	
	private String nome;
	
	TipoRecrutamentoEnum(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (TipoRecrutamentoEnum tipo : TipoRecrutamentoEnum.values()) {			
			lista.add(tipo.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (TipoRecrutamentoEnum tipo : TipoRecrutamentoEnum.values()) {
			mapa.put(tipo.name(), tipo.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
}
