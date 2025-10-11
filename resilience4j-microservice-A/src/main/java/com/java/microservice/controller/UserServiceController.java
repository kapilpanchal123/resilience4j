package com.java.microservice.controller;

import com.java.microservice.data.OrderDTO;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/user-service")
@RequiredArgsConstructor
public class UserServiceController {

  private static final String USER_SERVICE = "userService";
  private static final String BASE_URL = "http://localhost:9002/api/v1/orders/";
  private int attempt = 1;

  private final RestTemplate restTemplate;

  @GetMapping(path = "/display-orders")
  @CircuitBreaker(name =USER_SERVICE,fallbackMethod = "getAllAvailableProducts")
  @Retry(name = USER_SERVICE)
  public ResponseEntity<List<OrderDTO>> displayOrders(@RequestParam String category) {
    String url = category == null ? BASE_URL : BASE_URL + "/" + category;
    log.info("Url: {}", url);
    log.info("Retry method called {} times at {}", attempt++, LocalDateTime.now());

    OrderDTO[] resultArray = restTemplate.getForObject(url, OrderDTO[].class);
    if (resultArray == null) {
      throw new IllegalStateException("No data returned from API");
    }
    List<OrderDTO> results = Arrays.asList(resultArray);
    return ResponseEntity.status(HttpStatus.OK).body(results);
  }

  private ResponseEntity<List<OrderDTO>> getAllAvailableProducts(Exception e) {
    List<OrderDTO> results = List.of(
        new OrderDTO(119, "Retry1", "electronics", "white", 45000.00),
        new OrderDTO(345, "Retry2", "electronics", "black", 7000.00),
        new OrderDTO(475, "Retry3", "electronics", "black", 13000.00),
        new OrderDTO(574, "Retry4", "foot wear", "black & white", 4600.00),
        new OrderDTO(678, "Retry5", "kitchen", "blue", 999.00),
        new OrderDTO(532, "Retry6", "kitchen", "gray", 745.00));

    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(results);
  }

}
