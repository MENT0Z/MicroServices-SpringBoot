package com.quiz.QuizService.Services;

import com.quiz.QuizService.Entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);

    List<Quiz>get();
    
    Quiz get(Long Id);

    
}
