package com.codeing.personal.repository;

import com.codeing.personal.entities.Directivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectivoRepository extends JpaRepository<Directivo, String> {
}
