package com.mylab.techLab.week7_testdouble.chapter7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegisterTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository userRepository = new MemoryUserRepository();
    private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker,userRepository,spyEmailNotifier);

    }


    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword(){
        stubWeakPasswordChecker.setWeak(true);

        assertThrows(WeakPasswordException.class, () -> {
           userRegister.register("id","pw","email");
        });
    }

    @DisplayName("동일 ID를 가진 존재")
    @Test
    void duplicateID(){
        userRepository.save(new User("id","pw1","email@email.com"));

        assertThrows(DupIdException.class, () -> {
            userRegister.register("id","pw","email");
        });
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendEmail(){
        userRegister.register("id","pw","email");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email", spyEmailNotifier.getEmail());

    }
}