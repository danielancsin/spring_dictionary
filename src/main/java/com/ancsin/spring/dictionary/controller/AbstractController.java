package com.ancsin.spring.dictionary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ancsin.spring.dictionary.entity.abstracts.AbstractEntity;
import com.ancsin.spring.dictionary.service.interfaces.AbstractService;

//@Controller
//@RequestMapping("/abstract")
public abstract class AbstractController<T extends AbstractEntity> {

	@Autowired
	private AbstractService<T> abstractService;

	@RequestMapping(method = RequestMethod.GET)
	public List<T> list() { return abstractService.findAll(); }

	@RequestMapping(method = RequestMethod.POST)
	public T create(@RequestBody T entity) { return abstractService.save(entity); }

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public T update(@PathVariable(value = "id") long id, @RequestBody T entity) { return abstractService.save(entity); }

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable(value = "id") long id) { abstractService.deleteById(id); }

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public T get(@PathVariable(value = "id") long id) { return abstractService.findById(id); }

}
