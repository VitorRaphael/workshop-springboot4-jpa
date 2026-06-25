package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Não precidamos instanciar essa interface pois só com o dados fornecidos
    // o Jpa já faz uma instanciação automática para esta interface
}
