package ru.itsjava.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JdbcTest
@Import(UserDaoImpl.class)
public class UserJdbcDaoImplTest {
    private static final int DEFAULT_AGE = 100;
    private static final String DEFAULT_NAME = "Dima 2";
    private static final long FIRST_ID = 1L;
    private static final Pet DEFAULT_PET = new Pet(1L, "Dog");
    @Autowired
    private UserDao userDao;

    @Test
    public void shouldHaveCorrectCount(){
        int actualStudentsCount = userDao.count();

        assertEquals(2, actualStudentsCount);
    }

    @Test
    public void shouldHaveCorrectInsert(){
        User expectedUser = new User(DEFAULT_NAME, DEFAULT_AGE, DEFAULT_PET);
        long idFromDB = userDao.insert(expectedUser);
        User actualUser = userDao.findById(idFromDB);

        assertAll(() -> assertEquals(actualUser.getName(), expectedUser.getName()),
                () -> assertEquals(actualUser.getAge(), expectedUser.getAge()));
    }

    @Test
    public void shouldHaveCorrectUpdate(){
        User expectedUser = new User(FIRST_ID, DEFAULT_NAME, DEFAULT_AGE, DEFAULT_PET);
        userDao.update(expectedUser);
        User actualUser = userDao.findById(FIRST_ID);

        assertEquals(actualUser, expectedUser);
    }

    @Test
    public void shouldHaveCorrectDelete(){
        User deletedUser = userDao.findById(FIRST_ID);
        userDao.delete(deletedUser);

        assertEquals(userDao.count(), 1);
    }
}
