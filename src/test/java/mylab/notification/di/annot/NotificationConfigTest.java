package mylab.notification.di.annot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationConfig;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.SmsNotificationService;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    void testNotificationManagerDI() {
        // NotificationManager 주입 여부
        assertNotNull(notificationManager);

        // email
        assertNotNull(notificationManager.getEmailService());
        assertTrue(notificationManager.getEmailService() instanceof EmailNotificationService);
        EmailNotificationService emailService = (EmailNotificationService) notificationManager.getEmailService();
        assertEquals("Cooperear@github.com", emailService.getSmtpServer());
        assertEquals(4862, emailService.getPort());

        // SMS
        assertNotNull(notificationManager.getSmsService());
        assertTrue(notificationManager.getSmsService() instanceof SmsNotificationService);
        SmsNotificationService smsService = (SmsNotificationService) notificationManager.getSmsService();
        assertEquals("StarLink", smsService.getProvider());

        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
        
    }
}
