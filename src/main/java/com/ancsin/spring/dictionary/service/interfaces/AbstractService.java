package com.ancsin.spring.dictionary.service.interfaces;

import java.util.List;

public interface AbstractService<T> {
	
	public List<T> findAll();
	
	public T findById(long id);
	
	public void save(T t);
	
	public void deleteById(long id);

	public List<T> searchBy(String name);

}
