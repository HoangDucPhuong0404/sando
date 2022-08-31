package com.cg.tp.sandro.repositorys;

import com.cg.tp.sandro.repositorys.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IColorRepository extends JpaRepository<Color, Long> {

}
