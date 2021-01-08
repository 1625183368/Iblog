package com.mxx.blogs.appoint;

import com.mxx.blogs.dto.BLogsIndexDto;
import com.mxx.blogs.pojo.BlogsUser;
import com.mxx.blogs.result.SystemResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BLogsUserServiceAppoint {
    public static SystemResult checkUserInfo(String userName, String passWord) {

        // 校验用户名
        if (StringUtils.isEmpty(userName) || userName.length() < 7 || userName.length() > 11) {
            return new SystemResult(100, "用户名的长度为7~11位", null);
        }

        // 校验密码
        if (StringUtils.isEmpty(passWord) || passWord.length() < 7) {
            return new SystemResult(100, "密码的长度为7~15位", null);
        }
        return new SystemResult(200);

    }
    public static void commitUserInfo(BLogsIndexDto dto, BlogsUser user){
        dto.setUName(user.getUserName());
        dto.setUserName(user.getUserName());
        dto.setUserIcon(user.getUImage());
    }
}
