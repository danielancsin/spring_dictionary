package com.ancsin.spring.dictionary.entity;

public interface EnumInterface<E> {
	
	public int getId();
	
	public String getName();
	
	public E getByValue(int id);
	
}
