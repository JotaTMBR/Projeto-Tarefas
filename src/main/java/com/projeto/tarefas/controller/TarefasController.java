package com.projeto.tarefas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.tarefas.domain.Tarefas;
import com.projeto.tarefas.repository.Estado;
import com.projeto.tarefas.repository.TarefasRepository;

@RestController
public class TarefasController {
	@Autowired
	private TarefasRepository tr;

	@GetMapping("/tarefas/listar")
	public List<Tarefas> listar() {
		return tr.findAll();
	}
	@GetMapping("/tarefas/listar/{titulo}")
	public List<Tarefas> listarTitulo(@RequestParam String titulo){
		return tr.findByTitulo(titulo);
	}
	@GetMapping("/tarefas/listar/aberto")
	public List<Tarefas> listarAberto(Estado estado){
		return tr.findByEstado(Estado.Aberto);
	}
	@GetMapping("/tarefas/listar/finalizado")
	public List<Tarefas> listarFinalizado(Estado estado){
		return tr.findByEstado(Estado.Finalizado);
	}
	
	@PostMapping("/tarefas/cadastrar")
	public String cadastrar(@RequestBody Tarefas tarefas) {
		tr.save(tarefas);
		return "Cadastrado";
	}
	
	@PutMapping("/tarefas/atualizar/{id}")
	public String atualizar(@PathVariable Integer id, @RequestBody Tarefas tarefas) {
		String msg = "";
		Optional<Tarefas> t = tr.findById(id);
		
		if(t.isPresent()) {
			tarefas.setIdtarefa(id);
			tr.save(tarefas);
			msg = "Tarefa Atualizada";
		}
		else {
			msg = "Tarefa não Encontrada";
		}
		return msg;
	}
}