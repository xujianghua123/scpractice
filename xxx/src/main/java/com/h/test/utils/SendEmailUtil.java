package com.h.test.utils;

import org.apache.commons.mail.HtmlEmail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;

@Component
public class SendEmailUtil {

    @Autowired
    private JavaMailSender sender = new JavaMailSenderImpl();

    @Test
    public void testSendEmail(){
        HtmlEmail email = new HtmlEmail();
        // 发送方邮箱
        String sendFromMail= "wuliurucangyuyue@dongfangfuli.com";
        // 接收方邮箱
        List<String> sendToMails = Arrays.asList("xujianghua@dongfangfuli.com");
        // SMTP发送服务器
        String mailHostName = "smtp.exmail.qq.com";
        // 发送邮件主题
        String sendMailTheme= "预约单通知【test】";
        // 认证用户名
        String authUserName = "wuliurucangyuyue@dongfangfuli.com";
        // 认证用户密码
        String authPassword = "38m9Q7KX4czjfSyW";

        try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName(mailHostName);
            email.setSmtpPort(587);
            // 字符编码集的设置
            email.setCharset("utf-8");

            // 收件人的邮箱
            for (String mail: sendToMails){
                email.addTo(mail);
            }
            // 发送人的邮箱2
            email.setFrom(sendFromMail, "发送邮件测试");

            InternetAddress internetAddress = new InternetAddress("wuliu@dongfangfuli.com");
            InternetAddress internetAddress1 = new InternetAddress("yangjinwen@dongfangfuli.com");
            email.setCc(Arrays.asList(internetAddress,internetAddress1));
            // 如果需要认证信息的话，设置认证：用户名-密码     ***是你开启POP3服务时的授权码，不是登录密码
            email.setAuthentication(authUserName, authPassword);
            // 要发送的邮件主题
            email.setSubject(sendMailTheme);
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg("1111111");
            // 发送
            email.send();
        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }


    /**
     * 发送邮件
     *
     * @return
     */
    @Test
    public void sendEmail() {

        //发送简单邮件和html
        try {
            MimeMessage mimeMessage = sender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setFrom("xujianghua@dongfangfuli.com");
            mimeMessageHelper.setCc("xujianghua@dongfangfuli.com");
            mimeMessageHelper.setTo("lipengbo@dongfangfuli.com");
            mimeMessageHelper.setSubject("test ttt");
            mimeMessageHelper.setText("hello world", Boolean.TRUE);
            sender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
