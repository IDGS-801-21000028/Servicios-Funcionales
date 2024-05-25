package com.codeing.personal.repository;

import com.codeing.personal.entities.Escolares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaresRepository extends JpaRepository<Escolares,String> {
}
