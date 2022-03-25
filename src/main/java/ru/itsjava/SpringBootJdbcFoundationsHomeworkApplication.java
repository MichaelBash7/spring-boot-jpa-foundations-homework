package ru.itsjava;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;
import ru.itsjava.repository.UserRepository;

import java.sql.SQLException;


@SpringBootApplication
class SpringBootJpaFoundationsHomeworkApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringBootJpaFoundationsHomeworkApplication.class,args);

        PetRepository petRepository = context.getBean(PetRepository.class);
        System.out.println("petRepository.getById() = " + petRepository.getById(1L));

        Pet pet = new Pet(0L, "Parrot");
        petRepository.insert(pet);
        System.out.println("petRepository.getById(3L) = " + petRepository.getById(3L));

        Pet pet3 = petRepository.getById(3L);
        pet3.setSpecies("PARROT");
        petRepository.update(pet3);
        System.out.println("genreRepository.getById(3L) = " + petRepository.getById(3L));

        petRepository.deleteById(3L);
        System.out.println("genreRepository.getById(3L) = " + petRepository.getById(3L));

        UserRepository userRepository = context.getBean(UserRepository.class);
        System.out.println(userRepository.findAll());

    }
}
