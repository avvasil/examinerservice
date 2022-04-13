package pro.sky.java.course2.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyExists extends RuntimeException {
    public QuestionAlreadyExists(String message) {
        super(message);
    }
}