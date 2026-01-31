package com.example.excel_to_database.Service;

import com.example.excel_to_database.entity.Product;
import com.example.excel_to_database.helper.ProductHelper;
import com.example.excel_to_database.repository.ProductRepository;
import org.hibernate.id.uuid.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.MulticastChannel;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void save(MultipartFile file) throws IOException {
        List<Product> products = ProductHelper.convertExcelToListOfProduct( file.getInputStream());
        this.productRepository.saveAll(products);
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
}
