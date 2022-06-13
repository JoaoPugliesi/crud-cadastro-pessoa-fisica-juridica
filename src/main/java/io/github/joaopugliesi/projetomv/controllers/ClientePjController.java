package io.github.joaopugliesi.projetomv.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import io.github.joaopugliesi.projetomv.dto.ClientePjDto;

import io.github.joaopugliesi.projetomv.models.entity.ClientePj;
import io.github.joaopugliesi.projetomv.services.ClientePjService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cliente-pj")
public class ClientePjController {

	final ClientePjService clientePjService;

	public ClientePjController(ClientePjService clientePjService) {

		this.clientePjService = clientePjService;
	}

	@PostMapping
	public ResponseEntity<Object> saveClientePj(@RequestBody @Valid ClientePjDto clientePjDto) {
		ClientePj clientePj = new ClientePj();
		BeanUtils.copyProperties(clientePjDto, clientePj);
		clientePj.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(clientePjService.save(clientePj));

	}

	@GetMapping
	public ResponseEntity<List<ClientePj>> getAllClientePj() {
		return ResponseEntity.status(HttpStatus.OK).body(clientePjService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> getOneClientePj(@PathVariable(value = "id") Integer id) {
		Optional<ClientePj> clientePjOptional = clientePjService.findById(id);
		if (!clientePjOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Pessoa Jurídica não encontrada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clientePjOptional.get());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteClientePj(@PathVariable(value = "id") Integer id) {
		Optional<ClientePj> clientePjOptional = clientePjService.findById(id);
		if (!clientePjOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Pessoa Jurídica não encontrada.");
		}
		clientePjService.delete(clientePjOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Cliente Pessoa Jurídica deletada.");
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> updateClientePj(@PathVariable(value = "id") Integer id,
			@RequestBody @Valid ClientePjDto clientePjDto) {
		Optional<ClientePj> clientePjOptional = clientePjService.findById(id);
		if (!clientePjOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Pessoa Jurídica não encontrada.");
		}
		ClientePj clientePj = new ClientePj();
		BeanUtils.copyProperties(clientePjDto, clientePj);
		clientePj.setId(clientePjOptional.get().getId());
		clientePj.setDataRegistro(clientePjOptional.get().getDataRegistro());
		clientePj.setCnpj(clientePjOptional.get().getCnpj());
		return ResponseEntity.status(HttpStatus.OK).body(clientePjService.save(clientePj));

	}
}
