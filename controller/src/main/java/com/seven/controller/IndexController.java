package com.seven.controller;

import com.seven.common.utils.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @RequestMapping("/")
    public ApiResponse index() {
        return ApiResponse.success("hello,server11111!");
    }
}


