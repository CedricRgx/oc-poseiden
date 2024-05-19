package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the User entities.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    List<User> findAll();

    Optional<User> findById(Integer userId);

    Optional<User> findByUsername(String username);

    User save(User user);

    void deleteById(Integer userId);

}
