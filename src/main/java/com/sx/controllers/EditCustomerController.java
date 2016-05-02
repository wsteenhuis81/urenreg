package com.sx.controllers;

import com.sx.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditCustomerController {

    //instance of CustomerService to access utility methods (database access)
    @Autowired
    private CustomerRepository customerService;

    @RequestMapping(value="result", method= RequestMethod.GET)
    public String customerSearch(@ModelAttribute("customerSearch") String search, Model model) {
        model.addAttribute("searchresults", customerService.findByFirstName(search));
        return "/edit_customer";
    }
}