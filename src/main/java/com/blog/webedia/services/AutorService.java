package com.blog.webedia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.webedia.domain.Autor;
import com.blog.webedia.repositories.AutorRepository;
import com.blog.webedia.services.exception.ObjectNotFoundException;

@Service
public class AutorService {
	@Autowired
	private AutorRepository repo;

	public Autor find(Integer id) {
		Autor obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado!" + "\nId: " + id + "\nTipo: " + Autor.class.getName());
		}
		return obj;
	}

	public Autor insert(Autor obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Autor update(Autor obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}
