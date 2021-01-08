package com.mxx.blogs.mapper;

import com.mxx.blogs.pojo.BlogsUser;
import org.apache.ibatis.annotations.Param;

public interface BlogsUserMapper {

    BlogsUser getUserByNameAndPassword(@Param("username") String userName,@Param("password") String passWord);
}
