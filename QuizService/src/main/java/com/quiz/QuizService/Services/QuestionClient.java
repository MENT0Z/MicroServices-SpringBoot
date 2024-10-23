package com.quiz.QuizService.Services;

import com.quiz.QuizService.Entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// we use this when there is a single instance only in the server if there are multiple instance and need to load balance then replace port by name
//@FeignClient(url = "http://localhost:8082",value = "Question-Client")

// for load balancing for multiple instance
@FeignClient(name="QUESTIONSERVICE")
public interface QuestionClient {

    @GetMapping("/questions/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
}
