package com.mxx.blogs.service.impl;

import com.mxx.blogs.appoint.BLogsIndexAppoint;
import com.mxx.blogs.result.SystemResult;
import com.mxx.blogs.service.BLogsIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class BLogsIndexServiceImpl implements BLogsIndexService {
    @Autowired
    private BLogsIndexAppoint bLogsIndexAppoint;
    @Override
    public SystemResult index(HttpServletRequest request) throws Exception {
        Object user = request.getAttribute("user");
        return null;
    }
}
