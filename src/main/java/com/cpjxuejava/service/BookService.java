package com.cpjxuejava.service;

import com.cpjxuejava.domain.Books;
import com.cpjxuejava.domain.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    //登陆验证
    int  login(Login login);

    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById( int id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(int id);

    //查询全部的书
    List<Books> queryAllBook();

    Books queryBookByName(@Param("bookName") String bookName);
}

