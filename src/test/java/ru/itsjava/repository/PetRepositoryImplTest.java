package ru.itsjava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@Import(PetRepositoryImpl.class)
public class PetRepositoryImplTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PetRepository petRepository;

    @Test
    public void shouldHaveCorrectInsert(){
        var rat = new Pet(4L, "rat");
        petRepository.insert(rat);
        var actualPet = petRepository.getById(4L);

        Assertions.assertEquals(rat, actualPet);
    }

    @Test
    public void shouldHaveCorrectUpdate(){
        var pet = petRepository.getById(1L);
        pet.setSpecies("rat");
        petRepository.update(pet);
        var actualPet = petRepository.getById(1L);

        Assertions.assertEquals("rat", actualPet.getSpecies());
    }

    @Test
    public void shouldHaveCorrectDeleteById(){
        petRepository.deleteById(3L);
        var deletedPet = petRepository.getById(3L);

        Assertions.assertNull(deletedPet);
    }
}
