package com.example.excel_to_database.controller;

import com.example.excel_to_database.Service.ProductService;
import com.example.excel_to_database.entity.Product;
import com.example.excel_to_database.helper.ProductHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws IOException {
        if (ProductHelper.checkExcelFormat(file)){
            this.productService.save(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is save to db"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file");
    }

    @GetMapping()
    public List<Product> getAllProduct(){
        return this.productService.getAllProducts();
    }

}
