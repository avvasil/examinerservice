package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;

import java.util.Collection;

@RestController
public class JavaQuestionController {
    private final JavaQuestionService service;

    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }
    @GetMapping(path = "/exam/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }
    @GetMapping(path = "/exam/java/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("question") String answer) {
        return service.remove(question, answer);
    }
    @GetMapping(path = "/exam/java")
    public Collection<Question> getAllQuestions() {
        return service.getAll();
    }
}
