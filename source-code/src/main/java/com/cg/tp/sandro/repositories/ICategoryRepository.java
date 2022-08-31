package com.cg.tp.sandro.repositorys;

import com.cg.tp.sandro.repositorys.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
