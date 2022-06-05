package io.github.silvaalexsander.domain.repository;

import io.github.silvaalexsander.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
