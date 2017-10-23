package org.liufree.common;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author lwx
 * @date 5/11/17
 * @email liufreeo@gmail.com
 */
public class EmailUtil {

    public static void main(String args[]) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("2425580012@qq.com", "vqmgwtqviaobdicd"));
        email.setSSLOnConnect(true);
        email.setFrom("2425580012@qq.com");
        email.setSubject("TestMail");
        email.setMsg("This is a Test1 mail ... :-)");
        email.addTo("liufreeo@gmail.com");
        email.send();
    }
}
