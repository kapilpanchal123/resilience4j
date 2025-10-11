package com.java.catalog.controller;

import com.java.catalog.data.OrderDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/orders")
@RequiredArgsConstructor
public class CatalogServiceController {

  @GetMapping(path = "/get-all")
  public ResponseEntity<List<OrderDTO>> getOrders() {
    List<OrderDTO> results = List.of(
        OrderDTO.builder().name("mobile").category("electronics").color("white").price(20000.00).build(),
        OrderDTO.builder().name("T-Shirt").category("clothes").color("black").price(999.00).build(),
        OrderDTO.builder().name("Jeans").category("clothes").color("blue").price(1999.00).build(),
        OrderDTO.builder().name("Laptop").category("electronics").color("gray").price(50000.00).build(),
        OrderDTO.builder().name("digital watch").category("electronics").color("black").price(2500.00).build(),
        OrderDTO.builder().name("Fan").category("electronics").color("black").price(50000.00).build()
    );
    return ResponseEntity.status(HttpStatus.OK).body(results);
  }

  @GetMapping(path = "/{category}")
  public ResponseEntity<List<OrderDTO>> getOrdersByCategory(@PathVariable String category) {
    List<OrderDTO> results = List.of(
        OrderDTO.builder().name("mobile").category("electronics").color("white").price(20000.00).build(),
        OrderDTO.builder().name("Laptop").category("electronics").color("gray").price(50000.00).build(),
        OrderDTO.builder().name("digital watch").category("electronics").color("black").price(2500.00).build(),
        OrderDTO.builder().name("Fan").category("electronics").color("black").price(50000.00).build()
    );
    return ResponseEntity.status(HttpStatus.OK).body(results);
  }
}
