package com.contaazul.samples.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.mysema.query.annotations.QueryProjection;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private String name;

	@ManyToMany(targetEntity = Pessoa.class)
	private List<Pessoa> children;

	public Pessoa() {
		super();
	}

	@QueryProjection
	public Pessoa(String name) {
		this();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pessoa> getChildren() {
		return children;
	}

	public void setChildren(List<Pessoa> children) {
		this.children = children;
	}

}
