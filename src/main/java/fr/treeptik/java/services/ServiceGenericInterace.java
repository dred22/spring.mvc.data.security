package fr.treeptik.java.services;

import java.util.List;

public interface ServiceGenericInterace<T> {
	
	public List<T> findAll();
	public T findOne(Integer id);
	public T save(T obj);
	public void delete(Integer id);

}
