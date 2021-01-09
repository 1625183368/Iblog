package com.mxx.blogs.interceptor;

import com.mxx.blogs.appoint.BLogsIndexAppoint;
import com.mxx.blogs.contants.UserContants;
import com.mxx.blogs.dto.BLogsIndexDto;
import com.mxx.blogs.enums.BlogSysState;
import com.mxx.blogs.pojo.BlogsUser;
import com.mxx.blogs.result.SystemResult;
import com.mxx.blogs.service.BLogsUserService;
import com.mxx.blogs.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BLogsInterceptor implements HandlerInterceptor {
    /**
     *
     * @param request
     * @param response
     * @param handler
     * @return 登录信息
     * @throws Exception
     */
    @Autowired
    private BLogsUserService bLogsUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String cookieValue = CookieUtils.getCookieValue(request, UserContants.USER_KEY,true);
        SystemResult result = BLogsIndexAppoint.checkCookieUser(request,response);
        if (result.getStatus() != BlogSysState.SUCCESS.getVALUE()){
            return true;
        }
        BLogsIndexDto cookieData = (BLogsIndexDto) result.getData();
        //取Redis中相应的数据 如果为空 去数据库查找


        /////////////////////////////////////
        SystemResult databaseData = bLogsUserService.login(cookieData.getUserName(),cookieData.getPassWord(),request,response);
        if (databaseData.getStatus() == 200){
            BLogsIndexDto dto= (BLogsIndexDto) databaseData.getData();
            //将信息写入redis
            //
        }else{
            CookieUtils.deleteCookie(request,response,UserContants.USER_KEY);
        }
        request.setAttribute("user",(BlogsUser)databaseData.getData());
        return true;
    }
}
