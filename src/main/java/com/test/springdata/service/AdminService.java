package com.test.springdata.service;

import com.test.springdata.dto.AdminSaveDTO;
import com.test.springdata.entity.Admin;
import com.test.springdata.page.PageRequest;
import com.test.springdata.page.PageResponse;

import java.util.List;

public interface AdminService {

    List<Admin> findByUserName(String userName);

    Admin save(AdminSaveDTO admin);

    PageResponse<Admin> page(PageRequest pageRequest);

}
