package io.github.silvaalexsander.domain.repository;

import io.github.silvaalexsander.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select * from cliente c where c.nome like '%:nome%'", nativeQuery = true)
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying//usar essa anotation para transacoes diferentes de consultas
    void deleteByName(String nome);

 //   List<Cliente> findByNomeLike(String nome);
    boolean existsByNome(String nome);


    //metodo para retornar cliente junto com os pedidos
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
