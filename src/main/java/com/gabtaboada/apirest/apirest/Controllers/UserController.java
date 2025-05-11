package com.gabtaboada.apirest.apirest.Controllers;

import java.util.UUID;
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
import com.gabtaboada.apirest.apirest.Entities.User;
import com.gabtaboada.apirest.apirest.Repositories.UserRepository;

@RestController // Uso este decorador, ya que vamos a hacer una ApiRest
@RequestMapping("/users")
public class UserController {

    @Autowired // Automatiza rutas y procesos por nosotros
    private UserRepository userRepository;

    @GetMapping // Get Grupal
    public List<User> getUsers() {
        return userRepository.findAll();
        // Gracias a Spreen con .findAll() busco todos los valores del repositorio
    }

    @GetMapping("/{id}") // Get Individual
    public User getUserById(@PathVariable UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario con el ID: " + id));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user); // Graba en la base de datos y devuelve el producto
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User detallesUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        user.setUsername(detallesUser.getUsername());
        user.setPassword(detallesUser.getPassword());
        user.setStatus(detallesUser.getStatus());

        return userRepository.save(user);
    }

    // Ahi vengo

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        userRepository.delete(user);
        return "El producto con el ID: " + id + " fue eliminado correctamente";
    }

}
