package com.seven.controller;

import com.seven.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    @Autowired
    private MailService mailService;
    private int count=0;

//    @Scheduled(cron="* * */2 * * ?")
    private void process(){


        System.out.println("发送邮件任务启动。。");
        mailService.sendSimpleMail("1370729212@qq.com", "酸辣粉", "年后  红安可能我发你了网红");
        System.out.println("发送邮件任务结束。。。。");

        System.out.println("this is scheduler task runing  "+(count++));
    }
}
