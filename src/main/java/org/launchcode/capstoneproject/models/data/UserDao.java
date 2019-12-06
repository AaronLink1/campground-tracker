package org.launchcode.capstoneproject.models.data;

import org.launchcode.capstoneproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String email);
}
