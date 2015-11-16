package br.ucb.sisgese.controller;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class IndexController {
	private final Result result;
	
	public IndexController(Result result) {
		this.result = result;
	}
}
