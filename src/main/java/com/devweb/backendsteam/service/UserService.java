package com.devweb.backendsteam.service;

import com.devweb.backendsteam.model.User;
import com.devweb.backendsteam.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listarTodos() {
		return userRepository.findAll();
	}

	public Optional<User> buscarPorId(Long id) {
		return userRepository.findById(id);
	}

	public User adicionar(User user) {
		return userRepository.save(user);
	}

	public User alterar(User user) {
		return userRepository.save(user);
	}

	public void remover(Long id) {
		userRepository.deleteById(id);
	}
}