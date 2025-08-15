package mylab.notification.di.annot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        return new EmailNotificationService("Cooperear@github.com", 4862);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        return new SmsNotificationService("StarLink");
    }

    @Bean
    public NotificationManager notificationManager(
            EmailNotificationService emailService,
            SmsNotificationService smsService) {
        return new NotificationManager(emailService, smsService);
    }
}