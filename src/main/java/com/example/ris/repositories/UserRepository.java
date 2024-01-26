package com.example.ris.repositories;

import com.example.ris.models.entities.Radnik;
import com.example.ris.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    @Query("SELECT '*' FROM User u WHERE u.idUsera = :idUser")
    User getUserByID(@Param("idUser") String idUser);

    @Query("SELECT u FROM User u WHERE u.roleId = :roleId")
    List<User> getUsersByRole(@Param("roleId") int roleId);

}
