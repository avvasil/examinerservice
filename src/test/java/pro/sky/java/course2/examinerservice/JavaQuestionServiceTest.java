package pro.sky.java.course2.examinerservice;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.service.JavaQuestionService;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionServiceTest {

    private final JavaQuestionService out = new JavaQuestionService();
    private final Question question1 = new Question("Сколько бит в int", "16");
    private final Question question2 = new Question("Сколько бит в byte", "8");
    private String q1 = "Сколько бит в int";
    private String q2 = "Сколько бит в byte";
    private String a1 = "16";
    private String a2 = "8";

    @Test
    public void javaQuestionTestAddQuestion() {
        assertEquals(question1, out.add(q1, a1));
    }

    @Test
    public void javaQuestionTestRemoveQuestion() {
        assertEquals(question2, out.remove(q2, a2));
    }

    @Test
    public void javaQuestionTestGetAllQuestion() {

        Collection<Question> actual = new ArrayList<>();
        actual.add(question1);
        actual.add(question2);
        out.add("Сколько бит в int", "16");
        out.add("Сколько бит в byte", "8");

        assertEquals(out.getAll(), actual);
    }
}
