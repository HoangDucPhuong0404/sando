<<<<<<< HEAD
package com.cg.tp.sandro.services.size;


import com.cg.tp.sandro.repositories.SizeRepository;
import com.cg.tp.sandro.repositories.models.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SizeServiceimpl implements ISizeService{

    @Autowired
    private SizeRepository sizeRepository;


    @Override
    public List<Size> findAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Optional<Size> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Size getById(Long id) {
        return null;
    }

    @Override
    public Size save(Size size) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
=======
package com.cg.tp.sandro.services.size;//package com.cg.tp.sandro.services.size;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class SizeServiceimpl implements ISizeService{
//
//    @Autowired
//    private SizeRepository sizeRepository;
//
//
//    @Override
//    public List<Size> findAll() {
//        return sizeRepository.findAll();
//    }
//
//    @Override
//    public Optional<Size> findById(Long id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Size getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public Size save(Size size) {
//        return null;
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }
//}
>>>>>>> df4aeeb880421e6530fc993a53affde79843fbf9