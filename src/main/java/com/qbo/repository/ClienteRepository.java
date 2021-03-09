package com.qbo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qbo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query(
			value="SELECT c FROM Cliente c WHERE c.dnicliente = :documento"
			)
	Cliente obtenerClientePorDocumento(
			@Param("documento")String documento);
	
	@Query(
			value="SELECT c FROM Cliente c WHERE c.nomcliente LIKE %:nombre% ORDER BY c.idcliente"
			)
	List<Cliente>buscarClientePorNombreJPQL(
			@Param("nombre")String documento);
	
	@Query(
			value="SELECT * FROM cliente WHERE nomcliente LIKE %:nombre% ORDER BY idcliente",
			nativeQuery = true
			)
	List<Cliente>buscarClientePorNombreNativeQuery(
			@Param("nombre")String documento);
	
}
