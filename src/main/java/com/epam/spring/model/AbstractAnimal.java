package com.epam.spring.model;

import lombok.Setter;

public abstract class AbstractAnimal {
   protected String name;

   public void setName(String name) {
      this.name = name;
   }
}
