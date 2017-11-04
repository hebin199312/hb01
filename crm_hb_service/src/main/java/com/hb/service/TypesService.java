package com.hb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.dao.ITypesDAO;
import com.hb.entity.Types;

@Service("TypesService")
public class TypesService implements ITypesService {
	@Autowired
	private ITypesDAO typesDAO;
	
	/* (non-Javadoc)
	 * @see com.hb.service.ITypesService#addTypes(com.hb.entity.Types)
	 */
	public void addTypes(Types types){
		typesDAO.save(types);
		/*if (1==1) {
			throw new RuntimeException();
		}*/
		typesDAO.save(new Types("ssh001"));
	}
	
}
