package com.questions.QuestionService.Services;

import com.questions.QuestionService.Entities.Questions;

import java.util.List;

public interface QuestionServices {
    Questions createQsn(Questions qsn);

    Questions getOne(Long id);

    List<Questions>getAll();

    List<Questions>getQuestionsOfQuiz(Long quizId);

}
