package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.ExaminerServiceImpl;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private final Question question1 = new Question("Сколько бит в int", "16");
    private final Question question2 = new Question("Сколько бит в byte", "8");

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getRandomQuestionList() {

        Set<Question> questions = new HashSet<>();
        questions.add(question1);
        questions.add(question2);

        Question actual = new Question("Сколько бит в int", "16");

        Mockito.when(examinerService.getQuestions(1)).thenReturn(questions);
        assertEquals(javaQuestionService.getRandomQuestion(), actual);
    }
}