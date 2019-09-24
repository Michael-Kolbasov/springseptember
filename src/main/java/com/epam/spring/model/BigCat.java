package com.epam.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.DisposableBean;

@Data
@NoArgsConstructor
public class BigCat   extends Cat implements DisposableBean{

  @PostConstruct
  private void postConstruct() {
    System.out.println("BIG CAT CALL postConstruct");
  }

  @PreDestroy
  private void preDestroy() {
    System.out.println("BIG CAT CALL preDestroy");
  }


}
