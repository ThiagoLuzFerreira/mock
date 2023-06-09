package com.thiago.faker.repository;

import com.thiago.faker.model.RbrfCpf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RbrfRepository extends JpaRepository<RbrfCpf, Integer> {
}
