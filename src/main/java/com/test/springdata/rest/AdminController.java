package com.test.springdata.rest;


import com.test.springdata.dto.AdminSaveDTO;
import com.test.springdata.entity.Admin;
import com.test.springdata.page.PageRequest;
import com.test.springdata.page.PageResponse;
import com.test.springdata.service.AdminService;
import com.test.springdata.vo.AdminVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "后台用户管理")
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @ApiOperation("通过userName查询用户")
    @RequestMapping(value = "listByUserName", method = RequestMethod.GET)
    public @ResponseBody List<AdminVO> listByUserName(String userName) {
        List<Admin> adminList = adminService.findByUserName(userName);
        return new ModelMapper().map(adminList, new TypeToken<List<AdminVO>>() {}.getType());
    }

    @ApiOperation("保存用户信息")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    AdminVO save(@ApiParam @RequestBody @Validated AdminSaveDTO admin) {
        Admin savedAdmin = adminService.save(admin);
        return new ModelMapper().map(savedAdmin, AdminVO.class);
    }

    @ApiOperation("分页查询用户")
    @RequestMapping(value = "page", method = RequestMethod.POST)
    public @ResponseBody
    PageResponse<Admin> page(@ApiParam @RequestBody PageRequest pageRequest) {
        return adminService.page(pageRequest);
    }

}
