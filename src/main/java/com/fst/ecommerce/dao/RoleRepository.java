package com.fst.ecommerce.dao;

import java.util.Optional;
import com.fst.ecommerce.model.Role;
import com.fst.ecommerce.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}