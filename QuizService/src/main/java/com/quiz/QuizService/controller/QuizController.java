package com.quiz.QuizService.controller;

import com.quiz.QuizService.Entities.Quiz;
import com.quiz.QuizService.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // create
    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    // get all
    @GetMapping
    public List<Quiz>getAllQuiz(){
        return quizService.get();
    }

    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable Long id){
        return quizService.get(id);
    }

}
