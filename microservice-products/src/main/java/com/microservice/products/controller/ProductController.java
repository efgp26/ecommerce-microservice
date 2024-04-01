package com.microservice.products.controller;

import com.microservice.products.controller.dto.ApiResponses;
import com.microservice.products.controller.dto.ProductDTO;
import com.microservice.products.entities.ProductEntity;
import com.microservice.products.services.IProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/microservice/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> createUser(@RequestBody ProductDTO createProductDTO) {

        ProductEntity productEntity = ProductEntity.builder()
                .name(createProductDTO.getName())
                .description(createProductDTO.getDescription())
                .price(createProductDTO.getPrice())
                .stock(createProductDTO.getStock())
                .userId(createProductDTO.getUserId())
                .categoriesId(createProductDTO.getCategoriesId())
                .build();

        productService.save(productEntity);

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Usuario guardado", createProductDTO ));
    }

    @GetMapping("/findProductId/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {

        ObjectId idOb = new ObjectId(id);
        Optional<ProductEntity> optionalUser = productService.findByIdObject(idOb);
        if (optionalUser.isPresent()) {
            ProductEntity product = optionalUser.get();
            ProductDTO userDTO = ProductDTO.builder()
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .userId(product.getUserId())
                    .categoriesId(product.getCategoriesId())
                    .build();
            return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Producto encontrado",  userDTO));
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/listAllProducts")
    public ResponseEntity<?> findAll(){
        List<ProductDTO> productDTOList = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .stock(product.getStock())
                        .userId(product.getUserId())
                        .categoriesId(product.getCategoriesId())
                        .build())
                .toList();

        return  ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "", productDTOList ));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        ObjectId idOb = new ObjectId(id);
        try{
            Optional<ProductEntity> optionalProduct = productService.findByIdObject(idOb);
            if (optionalProduct.isPresent()){
                productService.deleteById(idOb);
                return ResponseEntity.ok(new ApiResponses<>(HttpStatus.OK.value(), true, "Producto eliminado con éxito", null ));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponses<>(HttpStatus.NOT_FOUND.value(), false, "Producto no encontrado", null));
    }

}
