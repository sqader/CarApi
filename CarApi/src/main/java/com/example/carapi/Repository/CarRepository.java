package com.example.carapi.Repository;

import com.example.carapi.Model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CarRepository extends JpaRepository<CarModel, Long>{
}
