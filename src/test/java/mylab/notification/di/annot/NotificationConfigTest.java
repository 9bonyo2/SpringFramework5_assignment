package mylab.notification.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void notificationManagerTest() {

        assertNotNull(notificationManager);

        // 이메일 서비스 형변환
        EmailNotificationService emailService = (EmailNotificationService)notificationManager.getEmailService();

        assertNotNull(emailService);
        assertEquals("smtp.gmail.com",emailService.getSmtpServer());
        assertEquals(587, emailService.getPort());

        // SMS 서비스 형변환
        SmsNotificationService smsService = (SmsNotificationService)notificationManager.getSmsService();

        assertNotNull(smsService);
        assertEquals("SKT", smsService.getProvider());

        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    
    }
}