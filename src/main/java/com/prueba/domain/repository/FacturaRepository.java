package com.prueba.domain.repository;

import com.prueba.persistence.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
