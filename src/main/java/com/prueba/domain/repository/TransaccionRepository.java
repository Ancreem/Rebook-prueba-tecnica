package com.prueba.domain.repository;

import com.prueba.persistence.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
}
