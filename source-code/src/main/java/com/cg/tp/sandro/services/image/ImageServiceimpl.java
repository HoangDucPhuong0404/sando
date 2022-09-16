package com.cg.tp.sandro.services.image;

import com.cg.tp.sandro.repositories.IImageRepository;
import com.cg.tp.sandro.repositories.models.ProductMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceimpl implements IImageService{

    @Autowired
    private IImageRepository imageRepository;


    @Override
    public void save(ProductMedia productMedia) {
        imageRepository.save(productMedia);
    }
}
