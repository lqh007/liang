package com.seven.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping("/bookList")
    public String list() {
        return "book/list";
    }

    @PreAuthorize("hasAuthority('bookAdd')")
    @GetMapping("/add.html")
    public String add() {
        return "book/add";
    }

    @PreAuthorize("hasAuthority('bookDetail')")
    @GetMapping("/detail.html")
    public String detail() {
        return "book/detail";
    }
}
