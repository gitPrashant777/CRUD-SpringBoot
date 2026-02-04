package com.crud.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crud.CRUD.Model.*;
@Repository
public interface ProductRepo extends JpaRepository<ProductModel,Integer>{

}
