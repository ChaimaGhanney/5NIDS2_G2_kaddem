/*package tn.esprit.spring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.*;
import tn.esprit.spring.kaddem.repositories.*;
import tn.esprit.spring.kaddem.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;*/

public class testkaddem {
  /*  @InjectMocks
    private UniversiteServiceImpl universiteService;

    @Mock
    private UniversiteRepository universiteRepository;

    @Mock
    private DepartementRepository departementRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllUniversites() {
        // Créez un exemple de liste d'universités
        List<Universite> universites = new ArrayList<>();
        universites.add(new Universite(1, "Universite 1"));
        universites.add(new Universite(2, "Universite 2"));
        when(universiteRepository.findAll()).thenReturn(universites);
        List<Universite> result = universiteService.retrieveAllUniversites();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testAddUniversite() {
        Universite universite = new Universite(3, "Universite 3");
        when(universiteRepository.save(any(Universite.class))).thenReturn(universite);
        Universite result = universiteService.addUniversite(universite);
        assertNotNull(result);
        assertEquals(universite, result);
    }

    @Test
    public void testUpdateUniversite() {
        Universite universite = new Universite(1, "Nouveau nom");
        when(universiteRepository.save(any(Universite.class))).thenReturn(universite);
        Universite result = universiteService.updateUniversite(universite);
        assertNotNull(result);
        assertEquals(universite, result);
    }

    @Test
    public void testRetrieveUniversite() {
        Integer universiteId = 1;
        when(universiteRepository.findById(eq(universiteId))).thenReturn(Optional.of(new Universite(universiteId, "Universite 1")));
        Universite result = universiteService.retrieveUniversite(universiteId);
        assertNotNull(result);
        assertEquals(universiteId, result.getIdUniv());
    }

    @Test
    public void testDeleteUniversite() {
        // Créez un exemple d'ID d'université à supprimer
        Integer universiteId = 1;
        Universite universite = new Universite(universiteId, "Universite 1");

        // Configurez le comportement du mock pour la méthode findById() et delete()
        when(universiteRepository.findById(eq(universiteId))).thenReturn(Optional.of(universite));
        doNothing().when(universiteRepository).delete(eq(universite));

        // Appelez la méthode à tester
        universiteService.deleteUniversite(universiteId);

        // Vérifiez que la méthode a correctement supprimé l'université
        verify(universiteRepository, times(1)).delete(eq(universite));
    }

    // Écrivez des méthodes de test similaires pour les autres méthodes de votre service.
*/}
