package com.expert.expertschool.controller;

import com.expert.expertschool.model.ExpertClass;
import com.expert.expertschool.model.Person;
import com.expert.expertschool.repository.ExpertClassRepository;
import com.expert.expertschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ExpertClassRepository expertClassRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model) {
        List<ExpertClass> expertClasses = expertClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("expertClasses", expertClasses);
        modelAndView.addObject("expertClass", new ExpertClass());
        return modelAndView;
    }

    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(Model model, @ModelAttribute("expertClass") ExpertClass expertClass) {
        expertClassRepository.save(expertClass);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @RequestMapping("/deleteClass")
    public ModelAndView deleteClass(Model model, @RequestParam int id) {
        Optional<ExpertClass> expertClass = expertClassRepository.findById(id);
        for(Person person : expertClass.get().getPersons()){
            person.setExpertClass(null);
            personRepository.save(person);
        }
        expertClassRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @GetMapping("/displayStudents")
    public ModelAndView displayStudents(Model model, @RequestParam int classId, HttpSession session,
                                        @RequestParam(value = "error", required = false) String error) {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("students.html");
        Optional<ExpertClass> expertClass = expertClassRepository.findById(classId);
        modelAndView.addObject("expertClass",expertClass.get());
        modelAndView.addObject("person",new Person());
        session.setAttribute("eazyClass",expertClass.get());
        if(error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(Model model, @ModelAttribute("person") Person person, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        ExpertClass expertClass = (ExpertClass) session.getAttribute("expertClass");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if(personEntity==null || !(personEntity.getPersonId()>0)){
            modelAndView.setViewName("redirect:/admin/displayStudents?classId="+ expertClass.getClassId()
                    +"&error=true");
            return modelAndView;
        }
        personEntity.setExpertClass(expertClass);
        personRepository.save(personEntity);
        expertClass.getPersons().add(personEntity);
        expertClassRepository.save(expertClass);
        modelAndView.setViewName("redirect:/admin/displayStudents?classId="+ expertClass.getClassId());
        return modelAndView;
    }

    @GetMapping("/deleteStudent")
    public ModelAndView deleteStudent(Model model, @RequestParam int personId, HttpSession session) {
        ExpertClass expertClass = (ExpertClass) session.getAttribute("expertClass");
        Optional<Person> person = personRepository.findById(personId);
        person.get().setExpertClass(null);
        expertClass.getPersons().remove(person.get());
        ExpertClass expertClassSaved = expertClassRepository.save(expertClass);
        session.setAttribute("expertClass", expertClassSaved);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayStudents?classId="+ expertClass.getClassId());
        return modelAndView;
    }
}
