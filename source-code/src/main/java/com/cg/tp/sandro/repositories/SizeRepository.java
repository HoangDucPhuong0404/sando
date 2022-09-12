package com.cg.tp.sandro.repositories;

import com.cg.tp.sandro.repositories.models.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size,Long> {

   Boolean existsBySize(String size);
}
