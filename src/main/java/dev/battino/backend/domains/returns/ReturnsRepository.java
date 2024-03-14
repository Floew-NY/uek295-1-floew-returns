package dev.battino.backend.domains.returns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnsRepository extends JpaRepository<Returns, Integer> {
}
