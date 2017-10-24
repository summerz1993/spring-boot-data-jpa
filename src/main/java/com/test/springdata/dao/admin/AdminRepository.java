package com.test.springdata.dao.admin;

import com.test.springdata.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String> {

    List<Admin> findByUserName(String userName);

}
