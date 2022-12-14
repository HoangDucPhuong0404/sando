package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Boolean existsByTitle(String title);
}
