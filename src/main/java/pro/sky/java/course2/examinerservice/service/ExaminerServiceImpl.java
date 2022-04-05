package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.QuestionAlreadyExists;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new QuestionAlreadyExists("Запрошено большее количество вопросов, чем хранится в списке.");
        }
        Set<Question> randomQuestionsList = new HashSet<>();
        while (randomQuestionsList.size() < amount) {
            Question randomQuestion = questionService.getRandomQuestion();
                randomQuestionsList.add(randomQuestion);
        }
        return randomQuestionsList;
    }
}


