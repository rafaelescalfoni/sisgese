package br.ucb.sisgese.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum NivelInstrucaoEnum {
	FUNDAMENTAL("Ensino Fundamental"),
	MEDIO("Ensino Médio"),
	TECNICO("Ensino Técnico"),
	TECNOLOGO("Ensino Superior Tecnológico"),
	BACHARELADO("Ensino Superior"),
	ESPECIALIZACAO("Pós-graduação Latu Senso"),
	MESTRADO("Mestrado"),
	DOUTORADO("Doutorado"),
	POSDOC("Pós-Doutorado");
	
	private String nome;
	
	NivelInstrucaoEnum(String nome) {
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
		
		for (NivelInstrucaoEnum obj : NivelInstrucaoEnum.values()) {			
			lista.add(obj.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (NivelInstrucaoEnum obj : NivelInstrucaoEnum.values()) {
			mapa.put(obj.name(), obj.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
}
