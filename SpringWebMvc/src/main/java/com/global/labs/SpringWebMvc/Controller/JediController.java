package com.global.labs.SpringWebMvc.Controller;

import com.global.labs.SpringWebMvc.Model.Jedi;
import com.global.labs.SpringWebMvc.Repositorio.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class JediController {

    @Autowired
    private JediRepository repository;

    @GetMapping("/Jedi")
    public ModelAndView jedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Jedi");

        modelAndView.addObject("alljedi", repository.getAllJedi());
        return modelAndView;
    }

    @GetMapping("New-Jedi")
    public ModelAndView newJedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("New-Jedi");

        modelAndView.addObject("jedi",new Jedi());
        return modelAndView;
    }

    @PostMapping("/Jedi")
    public String createJedi(@ModelAttribute Jedi jedi){
        repository.add(jedi);
        return "redirect:Jedi";
    }

}
