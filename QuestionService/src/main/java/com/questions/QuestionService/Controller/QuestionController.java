package com.questions.QuestionService.Controller;

import com.questions.QuestionService.Entities.Questions;
import com.questions.QuestionService.Services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionServices questionServices;

    // create
    @PostMapping("/create")
    private Questions createQuestion(@RequestBody Questions questions){
        return questionServices.createQsn(questions);
    }

    // get all
    @GetMapping
    private List<Questions>getAllQuestion(){
        return questionServices.getAll();
    }

    // getQsnById
    @GetMapping("/{questionId}")
    private Questions getQsnById(@PathVariable Long questionId){
        return questionServices.getOne(questionId);
    }

    //get all qsn for specific quiz
    @GetMapping("/quiz/{quizId}")
    private List<Questions> getAllQsnByQuizId(@PathVariable Long quizId){
        return questionServices.getQuestionsOfQuiz(quizId);
    }
    // now we need to communicate between two micorservices for that we need to use the following
    /*
    * 1. Rest Template its now deprecated
    * 2. webclient
    * 3. Openfeign (currently we are using) to use openFeign we need to put the dependency fo openFeign to the microservice
    * which we are calling
    * */

}
