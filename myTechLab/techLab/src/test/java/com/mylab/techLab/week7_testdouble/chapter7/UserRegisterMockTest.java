package com.mylab.techLab.week7_testdouble.chapter7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class UserRegisterMockTest {

    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = Mockito.mock(StubWeakPasswordChecker.class);
    private MemoryUserRepository userRepository = Mockito.mock(MemoryUserRepository.class);
    private SpyEmailNotifier spyEmailNotifier = Mockito.mock(SpyEmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker,userRepository,spyEmailNotifier);

    }


    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword(){
        //pw인자를 받았으면 true를 반환해라!
        given(stubWeakPasswordChecker.checkPassword("pw")).willReturn(true);

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

    @DisplayName("회원 가입시 암호 검사 수행함")
    @Test
    void checkPassword(){
        userRegister.register("id","pw","email");
       then(stubWeakPasswordChecker).should().checkPassword(anyString());
       //stubWeakPasswordCheck를  메서드를 호출하면 호출 여부를 판단
    }

    @DisplayName("가입하면 메일을 전송함")
    @Test
    void whenRegisterThenSendEmail(){
        userRegister.register("id","pw","email");

        assertTrue(spyEmailNotifier.isCalled());
        assertEquals("email", spyEmailNotifier.getEmail());

    }
}