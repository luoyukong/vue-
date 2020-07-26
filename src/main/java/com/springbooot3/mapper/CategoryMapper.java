package com.springbooot3.mapper;

import java.util.List;

import com.springbooot3.pojo.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CategoryMapper {

    @Select("select * from user ")
    List<Category> findAll();

    @Insert(" insert into user #{id},#{username},{password}")
    public int save(String username,String password);

    @Delete(" delete from user where id= #{id} ")
    public void delete(int id);

    @Select("select * from user where id= #{id} ")
    public Category get(int id);

    @Update("update user set name=#{name} where id=#{id} ")
    public int update(String username,String password);

}
