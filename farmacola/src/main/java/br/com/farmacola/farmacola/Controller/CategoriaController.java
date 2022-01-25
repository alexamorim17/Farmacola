package br.com.farmacola.farmacola.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farmacola.farmacola.Model.Categoria;
import br.com.farmacola.farmacola.Repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
public class CategoriaController{
		
		@Autowired
		private CategoriaRepository repository;

		@GetMapping
		public ResponseEntity<List<Categoria>> GetAll() {
			return ResponseEntity.ok(repository.findAll());

		}

		@GetMapping("/{id}")
		public ResponseEntity<Categoria> GetByID(@PathVariable long id) {
			return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}

		@GetMapping("/descricao/{descricao}")
		public ResponseEntity<List<Categoria>> GetByDescricao(@PathVariable String descricao) {
			return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
		}

		@PostMapping
		public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
		}

		@PutMapping
		public ResponseEntity<Categoria> put( @RequestBody Categoria produto) {
			return repository.findById(produto.getId()).map(resposta -> ResponseEntity.ok().body(repository.save(produto)))
					.orElse(ResponseEntity.notFound().build());
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<?> deletePostagem(@PathVariable long id) {
			return repository.findById(id).map(resposta -> {
				repository.deleteById(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}).orElse(ResponseEntity.notFound().build());
		}
	}



