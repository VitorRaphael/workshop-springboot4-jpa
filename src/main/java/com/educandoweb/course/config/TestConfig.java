package com.educandoweb.course.config;


import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // Realizando uma inserção de independencia aclopada ("Fraca");
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        // Salvando essas categorias no banco de dados
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));


        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "9888888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "9777777777", "123456");

        Order o1 = new Order(null, u1, OrderStatus.PAID, Instant.parse("2019-06-20T19:53:07Z"));
        Order o2 = new Order(null, u2,OrderStatus.WAITING_PAYMENT, Instant.parse("2019-07-21T03:42:10Z"));
        Order o3 = new Order(null, u1, OrderStatus.WAITING_PAYMENT, Instant.parse("2019-07-22T15:21:22Z"));

        // Salvando esses dados no meu Banco de Dados
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
