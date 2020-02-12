package org.thor.miaosha.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.thor.miaosha.entity.User;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-12 上午7:37
 * @Version: V1.0
 */
@Repository
@Mapper
public interface UserDao {

    /**
     * 查询 by ID
     *
     * @param id
     * @return
     */
    @Select({"select * from user where id = #{id}"})
    User getById(@Param("id") Integer id);

    /**
     * 新增
     *
     * @param user
     * @return
     */
    @Insert("insert into user(id, username, age)values(#{id}, #{username}, #{age})")
    Integer insert(User user);
}
