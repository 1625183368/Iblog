package com.mxx.blogs.dto;

import com.mxx.blogs.pojo.BlogsArticle;
import lombok.Data;

import java.util.List;

@Data
public class BLogsIndexDto {
    private String uName;
    private String userName;
    private String userIcon;
    private String passWord;
    private boolean isLogin;
    private List<BlogsArticle> articles;
}
