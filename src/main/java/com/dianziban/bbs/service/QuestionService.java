package com.dianziban.bbs.service;

import com.dianziban.bbs.dao.QuestionDao;
import com.dianziban.bbs.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDao.selectLatestQuestions(userId, offset, limit);
    }
}
