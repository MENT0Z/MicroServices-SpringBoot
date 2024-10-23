package com.quiz.QuizService.Services.impl;

import com.quiz.QuizService.Entities.Quiz;
import com.quiz.QuizService.Repositories.QuizRepo;
import com.quiz.QuizService.Services.QuestionClient;
import com.quiz.QuizService.Services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpel implements QuizService {

    @Autowired
    QuizRepo quizRepo;

    // this is as same as
//    private  QuizRepo quizRepoo;
//    public QuizServiceImpel(QuizRepo quizRepoo) {
//        this.quizRepoo = quizRepoo;
//    }

    @Autowired
    public QuestionClient questionClient;


    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> get() {

        // WE CAN DIRECTLY RETURN  quizRepo.findAll() AND THIS WILL NOT ADD QSN IN QUIZ FROM ANOTHER MICROSERVICE

        List<Quiz>quizzes = quizRepo.findAll();
//        List<Quiz>newQuizList= quizzes.stream().map(quiz -> {
//            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
//            return quiz;
//        }).collect(Collectors.toList());

        return quizzes.stream().peek(quiz -> quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()))).toList();
    }

    @Override
    public Quiz get(Long Id) {
        Quiz quiz = quizRepo.findById(Id).orElseThrow(()-> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
