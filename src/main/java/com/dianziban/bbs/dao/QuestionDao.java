package com.dianziban.bbs.dao;

import com.dianziban.bbs.model.Question;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionDao {
    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title, content, created_date, user_id, comment_count ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{title},#{content},#{createdDate},#{userId},#{commentCount})"})
    int addQuestion(Question question);

    @Select({"select", SELECT_FIELDS,"from",TABLE_NAME,"where user_id = #{userId} order by id desc LIMIT #{offset},#{limit}"})
    List<Question> selectLatestQuestions(@Param("userId") int userId, @Param("offset") int offset,
                                         @Param("limit") int limit);
}
