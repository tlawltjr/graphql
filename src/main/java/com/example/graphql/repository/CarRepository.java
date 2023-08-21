package com.example.graphql.repository;

import com.example.graphql.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.graphql.data.GraphQlRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@GraphQlRepository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMemberId(int memberId);
}
