package com.lelecodev.userdept.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lelecodev.userdept.entities.User;
import com.lelecodev.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserControllers extends User {
	@Autowired
	private UserRepository repository;
	//GetAll (Puxa todos os dados do banco de dados)
	@GetMapping
	public List<User> findAll() {
		List<User> result = repository.findAll();
		return result;
	}	
	//Get (Puxa os dados de um usuario pelo ID)
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}
	//Put (Insere um novo usuario no banco de dados)
	@PostMapping
	public User insert(@RequestBody User user ) {
		User result = repository.save(user);
		return result;
	}
	//Delete (Deleta dados de um usuario pelo ID)
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
			repository.deleteById(id);
	}
	
	// Update (Atualiza os dados de um usuario pelo ID)
	@PutMapping(value = "/{id}")
	public Object update(@PathVariable Long id, @RequestBody User user) {
		User  existingUser = repository.findById(id).orElse(null);
		if (existingUser != null) {
            // Atualizamos os campos do usuário existente com os dados do usuário fornecido
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            // Salvamos a atualização no banco de dados
            User updatedUser = repository.save(existingUser);
		return updatedUser;
	} else {
		return null;
	}
}
}