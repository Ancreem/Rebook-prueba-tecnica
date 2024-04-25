package com.prueba.domain.repository;

import com.prueba.persistence.facturaXproducto.FacturaXProducto;
import com.prueba.persistence.facturaXproducto.FacturaXProductoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaXProductoRepository extends JpaRepository<FacturaXProducto, FacturaXProductoId> {
}
