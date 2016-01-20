package com.marvinformatics.samples.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person
{

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  private String name;

  @ManyToMany(targetEntity = Person.class)
  private List<Person> children;

  public Person()
  {
    super();
  }

  public Person(String name)
  {
    this();
    this.name = name;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public List<Person> getChildren()
  {
    return children;
  }

  public void setChildren(List<Person> children)
  {
    this.children = children;
  }

}
