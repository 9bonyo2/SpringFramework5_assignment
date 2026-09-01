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

        assertNotNull(notificationManager.getEmailService());
        assertEquals("smtp.gmail.com", notificationManager.getEmailService().getSmtpServer());
        assertEquals(587,
                notificationManager.getEmailService().getPort());

        assertNotNull(notificationManager.getSmsService());
        assertEquals("SKT", notificationManager.getSmsService().getProvider());

        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}