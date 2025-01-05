package com.satya.spring_boot_assignment.comic_service.repository;

import com.satya.spring_boot_assignment.comic_service.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Long> {
}
