package com.quiz.QuizService.Repositories;

import com.quiz.QuizService.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Long> {

}
