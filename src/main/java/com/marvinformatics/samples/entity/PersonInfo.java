package com.marvinformatics.samples.entity;

import com.querydsl.core.annotations.QueryProjection;

public class PersonInfo
{

  private String name;
  private int childCount;

  @QueryProjection
  public PersonInfo(String name, int childCount)
  {
    this.name = name;
    this.childCount = childCount;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getChildCount()
  {
    return childCount;
  }

  public void setChildCount(int childCount)
  {
    this.childCount = childCount;
  }

}
