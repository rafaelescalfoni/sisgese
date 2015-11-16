package br.ucb.sisgese.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public enum StatusVagaEnum {
	ABERTA("Aberta"), 
	PENDENTE("Pendente"),
	PREENCHIDA("Preenchida");
	
	private String nome;
	
	StatusVagaEnum(String nome) {
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
		
		for (StatusVagaEnum status : StatusVagaEnum.values()) {			
			lista.add(status.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (StatusVagaEnum status : StatusVagaEnum.values()) {
			mapa.put(status.name(), status.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
}
