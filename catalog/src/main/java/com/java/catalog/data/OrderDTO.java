package com.java.catalog.data;

import java.io.Serial;
import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String name;
  private String category;
  private String color;
  private Double price;
}
