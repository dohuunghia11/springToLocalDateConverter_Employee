package com.codegym.cms.controller;

import com.codegym.cms.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @GetMapping("/add-employee")
    public ModelAndView inputEmployee() {
        ModelAndView modelAndView = new ModelAndView("/employee/EmployeeForm");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @RequestMapping(value = "/save-employee")
    public String saveEmployee(@ModelAttribute Employee employee, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorMessage", bindingResult.getAllErrors());
            return "/employee/EmployeeForm";
        }

        // save employee here...

        model.addAttribute("employee", employee);
        return "/employee/EmployeeDetail";
    }
}
