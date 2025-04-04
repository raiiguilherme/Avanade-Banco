package org.rai.projetoavanade.repository;


import org.rai.projetoavanade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String number);
}
