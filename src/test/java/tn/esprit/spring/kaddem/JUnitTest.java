package tn.esprit.spring.kaddem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JUnitTest {
    @Autowired
    DepartementServiceImpl departementService;
    @Autowired
    DepartementRepository departementRepository;




    @Test
    public void testDeleteNonExistentDepartment() {
        int nonExistentDepartment = 999; // Use a product ID that doesn't exist

        // Act: Perform the operation being tested
        departementService.deleteDepartement(nonExistentDepartment);

        // Assert: Verify the expected state or side effects
        assertNull(departementRepository.findById(nonExistentDepartment));
    }

    @Test
    public void testDeleteExistingDepartment() {
        int existingDepartement = 3; // Use a product ID that exists

        // Act: Perform the operation being tested
        departementService.deleteDepartement(existingDepartement);

        // Assert: Verify the expected state or side effects
          Optional<Departement> departmentOptional = departementRepository.findById(existingDepartement);
        assertFalse(departmentOptional.isPresent()); // Check if the Optional is empty
    }
}
