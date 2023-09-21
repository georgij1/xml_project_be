package com.xml_project_be.xml_project.dao;

import com.xml_project_be.xml_project.models.Role;
import com.xml_project_be.xml_project.models.State;
import com.xml_project_be.xml_project.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Query(value = "SELECT u FROM User as u WHERE" +
            " (:firstName is null or u.firstName like %:firstName%) and" +
            " (:lastName is null or u.lastName like %:lastName% ) and" +
            " (:secondName is null or u.secondName like %:secondName%) and" +
            " (:login is null or u.login like %:login%) and" +
            " (:email is null or u.email like %:email%) and" +
            " (:role is null or u.role=:role) and"+
            " (:state is null or u.state=:state) and" +
            " (:phoneNumber is null or u.phoneNumber like %:phoneNumber%)"
    )
    List<User> filter(
            String firstName,
            String lastName,
            String secondName,
            String login,
            String email,
            Role role,
            State state,
            String phoneNumber
    );
}
