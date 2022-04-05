package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questions = new HashSet<>();
    private final Random randomNumber = new Random();

    @Override
    public Question add(String question, String answer) {
        Question addingQuestion = new Question(question, answer);
        questions.add(addingQuestion);
        return addingQuestion;
    }

    @Override
    public Question remove(String question, String answer) {
        Question removingQuestion = new Question(question, answer);
        questions.remove(removingQuestion);
        return removingQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> randomQuestion = new ArrayList<>(questions);
        return randomQuestion.get(randomNumber.nextInt(questions.size()));
    }
}
