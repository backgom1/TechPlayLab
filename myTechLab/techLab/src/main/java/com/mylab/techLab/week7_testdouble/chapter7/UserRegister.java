package com.mylab.techLab.week7_testdouble.chapter7;

public class UserRegister {

    private WeakPasswordChecker weakPasswordChecker;
    private UserRepository userRepository;
    private EmailNotifier emailNotifier;

    //인터페이스로 구현하여 테스트 코드를 받아도 동작 할 수 있도록 작업해야한다. DIP원칙을 중요시한다.
    public UserRegister(WeakPasswordChecker weakPasswordChecker, UserRepository userRepository, EmailNotifier spyEmailNotifier) {
        this.weakPasswordChecker = weakPasswordChecker;
        this.userRepository = userRepository;
        this.emailNotifier = spyEmailNotifier;
    }

    public void register(String id, String pw, String email) {
        if (weakPasswordChecker.checkPassword(pw)) {
            throw new WeakPasswordException();
        }

        User user = userRepository.findById(id);
        if(user!= null){
            throw new DupIdException();
        }

        userRepository.save(new User(id, pw, email));

        emailNotifier.sendRegisterEmail(email);
    }
}
