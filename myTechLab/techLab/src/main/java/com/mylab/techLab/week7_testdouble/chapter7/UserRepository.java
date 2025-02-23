package com.mylab.techLab.week7_testdouble.chapter7;

public interface UserRepository {
    void save(User user);
    User findById(String id);
}
