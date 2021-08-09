package com.cpjxuejava.controller;

import com.cpjxuejava.domain.Books;
import com.cpjxuejava.domain.Login;
import com.cpjxuejava.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //Controller 调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/login")
    public String login(HttpSession session,Login login , Model model){
        System.out.println("进入到登陆控制器");
       /* bookService.login(login);
        session.setAttribute("userLoginInfo",login);
        Object obj =session.getAttribute("userLoginInfo");
        if(obj!=null){
            return "forward:/book/allBook";
        }else{
            return "login";
        }*/
        bookService.login(login);
        session.setAttribute("userLoginInfo",login);
        int i = bookService.login(login);
        model.addAttribute("Login", login);
        if(i>0){
            return "forward:/book/allBook";
        }else {
            return "redirect:/login.jsp";
        }

    }
    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook=>" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";     //重定向到我们的@RequestMapping("/allBook")
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdatePaper(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("Qbooks", books);
        return "updateBook";
    }

    //修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook==>" + books);
        int i = bookService.updateBook(books);
        if (i > 0) {
            System.out.println("添加books成功" + books);
        }
        return "redirect:/book/allBook";
    }


    //删除书籍
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }


    //查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = bookService.queryBookByName(queryBookName);

        System.err.println("book==>"+books);

        List<Books> list = new ArrayList<Books>();
        list.add(books);

        if (books == null) {
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list", list);
        return "allBook";

    }
}
