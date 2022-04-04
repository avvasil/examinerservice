package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.QuestionAlreadyExists;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<Question> randomQuestionsList = new ArrayList<>();
    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        Question randomQuestion;
        if (amount > questionService.getAll().size()) {
            throw new QuestionAlreadyExists("Запрошено большее количество вопросов, чем хранится в списке.");
        }
        while (randomQuestionsList.size() < amount) {
            randomQuestion = questionService.getRandomQuestion();
            if (!randomQuestionsList.contains(randomQuestion)) {
                randomQuestionsList.add(randomQuestion);
            }
        }
        return randomQuestionsList;
    }
}


