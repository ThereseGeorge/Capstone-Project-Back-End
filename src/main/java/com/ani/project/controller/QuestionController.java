package com.ani.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ani.project.dto.AnswerDto;
import com.ani.project.dto.QuestionDto;
import com.ani.project.service.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto questionDTO) {
        QuestionDto createdQuestion = questionService.createQuestion(questionDTO);
        return ResponseEntity.ok(createdQuestion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable("id") Long id) {
        QuestionDto question = questionService.getQuestion(id);
        return ResponseEntity.ok(question);
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        List<QuestionDto> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/answer/{id}")
    public ResponseEntity<AnswerDto> createAnswer(@PathVariable("id") Long questionId, @RequestBody AnswerDto answerDTO) {
        AnswerDto createdAnswer = questionService.createAnswer(questionId, answerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    

    @PutMapping("/answer/{id}")
    public ResponseEntity<AnswerDto> updateAnswer(@PathVariable("id") Long questionId, @RequestBody AnswerDto answerDTO) {
        AnswerDto updatedAnswer = questionService.updateAnswer(questionId, answerDTO);
        return ResponseEntity.ok(updatedAnswer);
    }

    @DeleteMapping("/answer/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable("id") Long questionId) {
        questionService.deleteAnswer(questionId);
        return ResponseEntity.noContent().build();
    }
}
