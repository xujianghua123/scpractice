package com.h.test.utils;

import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SendEmailUtil {

    @Test
    public void testSendEmail(){
        HtmlEmail email = new HtmlEmail();
        // 发送方邮箱
        String sendFromMail= "18236260673@163.com";
        // 接收方邮箱
        List<String> sendToMails = Arrays.asList("xujianghua@dongfangfuli.com","lipengbo@dongfangfuli.com");
        // SMTP发送服务器
        String mailHostName = "smtp.163.com";
        // 发送邮件主题
        String sendMailTheme= "发送邮件test";
        // 认证用户名
        String authUserName = "18236260673@163.com";
        // 认证用户密码
        String authPassword = "IMKUAOTGRTXTYHWR";

        try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName(mailHostName);
            // 字符编码集的设置
            email.setCharset("utf-8");

            // 收件人的邮箱
            for (String mail: sendToMails){
                email.addTo(mail);
            }
            // 发送人的邮箱2
            email.setFrom(sendFromMail, "行行");
            // 如果需要认证信息的话，设置认证：用户名-密码     ***是你开启POP3服务时的授权码，不是登录密码
            email.setAuthentication(authUserName, authPassword);
            // 要发送的邮件主题
            email.setSubject(sendMailTheme);
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg("is a test!");
            // 发送
            email.send();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }


}
