package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.ExaminerServiceImpl;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(path = "/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
