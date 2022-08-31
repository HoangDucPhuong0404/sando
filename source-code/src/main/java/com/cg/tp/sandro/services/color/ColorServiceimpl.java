<<<<<<< HEAD
package com.cg.tp.sandro.services.color;


import com.cg.tp.sandro.repositories.ColorRepository;
import com.cg.tp.sandro.repositories.models.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceimpl implements IColorService{

    @Autowired
    private ColorRepository colorRepository;


    @Override
    public List<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Color getById(Long id) {
        return null;
    }

    @Override
    public Color save(Color color) {
        return null;
    }


    @Override
    public void remove(Long id) {

    }
}
=======
package com.cg.tp.sandro.services.color;//package com.cg.tp.sandro.services.color;
//
//import com.cg.team_project2.model.Color;
//import com.cg.tp.sandro.repositorys.ColorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ColorServiceimpl implements IColorService{
//
//    @Autowired
//    private ColorRepository colorRepository;
//
//
//    @Override
//    public List<Color> findAll() {
//        return colorRepository.findAll();
//    }
//
//    @Override
//    public Optional<Color> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Color getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Color save(Color color) {
//        return null;
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }
//}
>>>>>>> df4aeeb880421e6530fc993a53affde79843fbf9
