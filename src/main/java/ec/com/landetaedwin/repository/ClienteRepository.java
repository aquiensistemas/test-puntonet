package ec.com.landetaedwin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.landetaedwin.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	List<Cliente> findByIdElemento(Integer id);

}