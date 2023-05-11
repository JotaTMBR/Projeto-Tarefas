package com.projeto.tarefas.domain;

import java.sql.Date;

import com.projeto.tarefas.repository.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefas {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false)
	private Integer idtarefa;
	
	@Column(nullable=false)
	private String titulo;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	private Date datainicio;
	
	@Column(nullable=false)
	private Date datatermino;
	
	@Column(nullable=false)
	private Estado estado;

	public Tarefas() {
	}

	public Tarefas(Integer idtarefa, String titulo, String descricao, Date datainicio, Date datatermino,
			Estado estado) {
		this.idtarefa = idtarefa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.datainicio = datainicio;
		this.datatermino = datatermino;
		this.estado = estado;
	}

	public Integer getIdtarefa() {
		return idtarefa;
	}

	public void setIdtarefa(Integer idtarefa) {
		this.idtarefa = idtarefa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDatainicio() {
		return datainicio;
	}

	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}

	public Date getDatatermino() {
		return datatermino;
	}

	public void setDatatermino(Date datatermino) {
		this.datatermino = datatermino;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
