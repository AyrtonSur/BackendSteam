package com.devweb.backendsteam.controller;

import com.devweb.backendsteam.model.User;
import com.devweb.backendsteam.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> listarTodos() {
		return userService.listarTodos();
	}

	@GetMapping("{userId}")
	public Optional<User> buscarPorUserId(@PathVariable String userId) {
		return userService.buscarPorUserId(userId);
	}

	@PostMapping
	public User adicionar(@RequestBody User user) {
		// user_id sempre será gerado no service
		return userService.adicionar(user);
	}

	@PutMapping
	public User alterar(@RequestBody User user) {
		return userService.alterar(user);
	}

	@DeleteMapping("{userId}")
	public void remover(@PathVariable String userId) {
		userService.buscarPorUserId(userId).ifPresent(u -> userService.remover(u.getId()));
	}
}