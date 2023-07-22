package com.github.willyao0523.springboot3inpractice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {

    List<VideoEntity> findByName(String name);

    @Query("select v from VideoEntity v where v.name = ?1")
    List<VideoEntity> findCustomerReport(String name);

    List<VideoEntity> findByDescriptionContainsIgnoreCase(String description);

    List<VideoEntity> findByNameContainsIgnoreCase(String name);

    List<VideoEntity> findByNameContainsOrDescriptionContainsAllIgnoreCase(String name, String description);
}
