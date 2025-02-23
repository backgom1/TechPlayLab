package com.mylab.techLab.week7_testdouble.chapter7;

import org.junit.jupiter.api.BeforeEach;

public class AutoDebitRegister_Fake_Test {

    private AutoDeBitRegister register;
    private StubCardNumberValidator cardNumberValidator;
    private MemoryAutoDebitInfoRepository repository;

    @BeforeEach
    void setUp() {
        cardNumberValidator = new StubCardNumberValidator();
        repository = new MemoryAutoDebitInfoRepository();
        register = new AutoDeBitRegister(cardNumberValidator,repository);
    }
}
