package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.User;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{
    private final EntityManager entityManager;


    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select distinct u from user u join fetch u.pet", User.class).getResultList();
    }
}
