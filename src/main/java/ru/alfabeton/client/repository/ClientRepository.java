package ru.alfabeton.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alfabeton.client.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {}
