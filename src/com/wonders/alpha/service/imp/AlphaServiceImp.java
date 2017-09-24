package com.wonders.alpha.service.imp;

import com.wonders.alpha.dao.AlphaDao;
import com.wonders.alpha.service.AlphaService;

public class  AlphaServiceImp implements AlphaService{
	
	private AlphaDao alphaDao;

	public void setAlphaDao(AlphaDao alphaDao) {
		this.alphaDao = alphaDao;
	}
	
	
	
}