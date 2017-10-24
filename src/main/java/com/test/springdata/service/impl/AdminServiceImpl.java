package com.test.springdata.service.impl;

import com.test.springdata.dao.admin.AdminRepository;
import com.test.springdata.dto.AdminSaveDTO;
import com.test.springdata.entity.Admin;
import com.test.springdata.page.PageInfo;
import com.test.springdata.page.PageRequest;
import com.test.springdata.page.PageResponse;
import com.test.springdata.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findByUserName(String userName) {
        return adminRepository.findByUserName(userName);
    }

    @Override
    public Admin save(AdminSaveDTO adminDTO) {
        Admin admin = new ModelMapper().map(adminDTO, Admin.class);
        admin.setCreateDate(new Date());
        return adminRepository.save(admin);
    }

    @Override
    public PageResponse<Admin> page(PageRequest pageRequest) {
        Pageable pageable = new Pageable() {
            @Override
            public int getPageNumber() {
                return pageRequest.getPageNo();
            }

            @Override
            public int getPageSize() {
                return pageRequest.getPageSize();
            }

            @Override
            public int getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
        Page<Admin> adminPage = adminRepository.findAll(pageable);

        PageResponse<Admin> pageResponse = new PageResponse<>();
        pageResponse.setData(adminPage.getContent());

        PageInfo pageInfo = new PageInfo((int)adminPage.getTotalElements(), pageRequest.getPageSize(), pageRequest.getPageNo());
        pageResponse.setPageInfo(pageInfo);

        return pageResponse;
    }
}
