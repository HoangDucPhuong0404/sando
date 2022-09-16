package com.cg.tp.sandro.services.size;


import com.cg.tp.sandro.dto.size.SizeParam;
import com.cg.tp.sandro.dto.size.SizeResult;
import com.cg.tp.sandro.repositories.models.Size;

import java.util.List;
import java.util.Optional;

public interface ISizeService {
    Optional<Size> findById(Long id);

    boolean existsBySize(String size);

    List<SizeResult> findAll();

    SizeResult create(SizeParam param);
}
