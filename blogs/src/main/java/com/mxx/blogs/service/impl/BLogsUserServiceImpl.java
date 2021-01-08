package com.mxx.blogs.service.impl;

import com.mxx.blogs.appoint.BLogsUserServiceAppoint;
import com.mxx.blogs.dto.BLogsIndexDto;
import com.mxx.blogs.mapper.BlogsUserMapper;
import com.mxx.blogs.pojo.BlogsUser;
import com.mxx.blogs.result.SystemResult;
import com.mxx.blogs.service.BLogsUserService;
import com.mxx.blogs.utils.CookieUtils;
import com.mxx.blogs.utils.JsonUtils;
import com.mxx.blogs.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class BLogsUserServiceImpl implements BLogsUserService{
    public static final String USER_KEY="Redis_key";
    @Autowired
    private BlogsUserMapper blogsUserMapper;
    @Override
    public SystemResult login(String userName, String passWord, HttpServletRequest request, HttpServletResponse response) {
        SystemResult systemResult = BLogsUserServiceAppoint.checkUserInfo(userName, passWord);
        if (systemResult.getStatus() != 200){
            return systemResult;
        }
        BlogsUser user = blogsUserMapper.getUserByNameAndPassword(userName, passWord);
        if (user == null || user.getPassWord().equals(MD5Utils.md5(passWord))){
            return new SystemResult(100,"用户名或密码错误");
        }
        BLogsIndexDto dto = new BLogsIndexDto();
        BLogsUserServiceAppoint.commitUserInfo(dto,user);
        CookieUtils.setCookie(request,response, USER_KEY,JsonUtils.objectToJson(dto),60*60*24*7);

        return new SystemResult();
    }
}
