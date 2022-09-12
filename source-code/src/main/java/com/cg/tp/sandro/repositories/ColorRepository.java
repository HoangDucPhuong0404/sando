package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,Long> {

    Boolean existsByTitle(String title);
}
