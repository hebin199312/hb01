package com.hb.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hb.entity.Types;
import com.hb.service.ITypesService;

@Controller("TepysAction")
public class TepysAction {
	@Autowired
	private ITypesService typesService;
	
	private Types types;

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}
	
	public String addTypes(){
		typesService.addTypes(types);
		return null;
	}
	
}
