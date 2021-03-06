package com.dianziban.bbs;

import com.dianziban.bbs.dao.QuestionDao;
import com.dianziban.bbs.dao.UserDao;
import com.dianziban.bbs.model.Question;
import com.dianziban.bbs.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Sql("/init-schema.sql")
public class InitDatabaseTests {
    @Autowired
    UserDao userDao;

    @Autowired
    QuestionDao questionDao;

    @Test
    public void contextLoads() {
        Random random = new Random();
        for (int i = 0; i < 11; ++i) {
            User user = new User();
            user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            user.setName(String.format("USER%d", i));
            user.setPassword(" ");
            user.setSalt("");
            userDao.addUser(user);

            user.setPassword("xx");
            userDao.updatePassword(user);

            Question question = new Question();
            question.setCommentCount(i);
            Date date = new Date();
            date.setTime(date.getTime() + 1000 * 3600 * i);
            question.setCreatedDate(date);
            question.setUserId(i + 1);
            question.setTitle(String.format("TITLE{%d}", i));
            question.setContent(String.format("AAA Content %d", i));

            questionDao.addQuestion(question);
        }

        Assert.assertEquals("xx",userDao.selectById(1).getPassword());
        userDao.deleteByid(1);
        Assert.assertNull(userDao.selectById(1));


        System.out.println(questionDao.selectLatestQuestions(0,0,10));

    }
}
