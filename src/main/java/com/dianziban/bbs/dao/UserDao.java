package com.dianziban.bbs.dao;


import com.dianziban.bbs.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    String TABLE_NAME = "user";
    String INSERT_FIELDS = "name, password, salt, head_url";
    String SELECT_FIELDS = "id, " + INSERT_FIELDS;

    //插入
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{name},#{password},#{salt},#{headUrl})"})
    int addUser(User user);

    //查询
    @Select({"select", SELECT_FIELDS, "from", TABLE_NAME, "where id = #{id}"})
    User selectById(int id);

    //更新
    @Update({"update", TABLE_NAME, "set password=#{password} where id=#{id}"})
    void updatePassword(User user);

    //删除
    @Delete({"delete from", TABLE_NAME," where id = #{id}"})
    void deleteByid(int id);

}
