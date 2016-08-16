package com.uran.controller;

import com.uran.model.User;
import com.uran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;
    private static final int limitResultsPerPage = 8;
    private int startpage, endpage;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping(value="/add", method= RequestMethod.GET)
    public ModelAndView addUserPage() {
        ModelAndView modelAndView = new ModelAndView("add-user-form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public ModelAndView addingUser(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("home");
        user.setCreatedDate(new Date());
        userService.addUser(user);
        String message = "User was successfully added.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value="/list")
    public ModelAndView listOfUsers(@RequestParam(value = "page", required = false) Integer page) {

        page = page != null ? page : 0;

        ModelAndView modelAndView = new ModelAndView("list-of-users");
        List<User> users = userService.getUsers(page);
        modelAndView.addObject("users", users);
        setPagingContext(userService.count(), page);
        modelAndView.addObject("startpage",startpage);
        modelAndView.addObject("endpage",endpage);

        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit-user-form");
        User user = userService.getUser(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editingUser(@ModelAttribute User user, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        userService.updateUser(user);
        String message = "User was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("home");
        userService.deleteUser(id);
        String message = "User was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value="/search")
    public ModelAndView inputUsers() {
        ModelAndView modelAndView = new ModelAndView("search-user-form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value="/outsearch")
    public ModelAndView nextPageOfUsers(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "page", required = false) Integer page)
    {

        page = page != null ? page : 0;

        ModelAndView modelAndView = new ModelAndView("search-of-users");
        List<User> users = userService.getUsersBySearch(name, page);
        modelAndView.addObject("user_name", name);
        modelAndView.addObject("page_num", page);
        modelAndView.addObject("users_search", users);

        setPagingContext(users.size(), page);
        modelAndView.addObject("startpage",startpage);
        modelAndView.addObject("endpage",endpage);

        return modelAndView;
    }

    private void setPagingContext(Integer size, Integer pageNumber){
        int numberOfPages = size/limitResultsPerPage;
        startpage = pageNumber - 5 > 0 ? pageNumber - 5 : 1;
        endpage = (numberOfPages > 10) ? startpage + 10 : startpage + numberOfPages;
    }
}