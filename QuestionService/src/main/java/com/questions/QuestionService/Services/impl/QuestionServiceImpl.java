package com.questions.QuestionService.Services.impl;


import com.questions.QuestionService.Entities.Questions;
import com.questions.QuestionService.Repositories.QuestionRepo;
import com.questions.QuestionService.Services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionServices {

    @Autowired
    QuestionRepo questionRepo;


    @Override
    public Questions createQsn(Questions qsn) {
        return questionRepo.save(qsn);
    }

    @Override
    public Questions getOne(Long id) {
        return questionRepo.findById(id).orElseThrow(()-> new RuntimeException("Question not found"));
    }

    @Override
    public List<Questions> getAll() {
        return questionRepo.findAll();
    }

    @Override
    public List<Questions> getQuestionsOfQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
