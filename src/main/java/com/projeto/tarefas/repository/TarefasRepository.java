package com.projeto.tarefas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.tarefas.domain.Tarefas;

@Repository
public interface TarefasRepository extends JpaRepository<Tarefas,Integer> {
	
	public List<Tarefas> findByTitulo(String titulo);
	
	public List<Tarefas> findByEstado(Estado estado);

}
