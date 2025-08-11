package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")

public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testDependencyInjection() {
        // 1. UserService 주입 여부
        assertNotNull(userService, "UserService 주입해줘 태일아");

        // 2. UserRepository 주입 여부
        assertNotNull(userService.getUserRepository(), "UserRepository 주입해줘 태일아");

        // 3. DB 타입이 Maria인지 검증
        assertEquals("Maria", userService.getUserRepository().getDbType(), "DB 타입이 Maria가 아니야");

        // 4. SecurityService 주입 여부
        assertNotNull(userService.getSecurityService(), "SecurityService주입해줘 태일아");

        // 5. registerUser() 실행 결과 확인
        assertTrue(userService.registerUser("hong", "홍길동", "1234"), "제대로 실행 안됐어 태일아");
    }
}