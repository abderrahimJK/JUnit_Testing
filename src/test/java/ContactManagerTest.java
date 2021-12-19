
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


import static org.junit.jupiter.api.Assertions.*;

class EtudiantManagerTest {


    private EtudiantManager etudiantManager;

    @BeforeAll
    public static void setupAll() {
        System.out.println("Doit afficher avant tous les tests");
    }

    @BeforeEach
    public void setup() {
        System.out.println("Instanciation du gestionnaire d'etudiant");
        etudiantManager = new EtudiantManager();
    }

    @Test
    @DisplayName("Devrait créer un etudiant")
    public void testCreateContact() {
        etudiantManager.addEtudiant("Ahmad", "Ahmadi", "D132404747");
        assertFalse(etudiantManager.getAllStudent().isEmpty());
        assertEquals(1, etudiantManager.getAllStudent().size());
    }

    @Test
    @DisplayName("Ne devrait pas créer un etudiant lorsque le prénom est nul")
    public void TestThrowRuntimeExceptionWhenFirstNameIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            etudiantManager.addEtudiant(null, "Ahmadi", "D132404747");
        });
    }

    @Test
    @DisplayName("Ne devrait pas créer un etudiant  lorsque le nom de famille est nul")
    public void testThrowRuntimeExceptionWhenLastNameIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            etudiantManager.addEtudiant("Ahmad", null, "D132404747");
        });
    }

    @Test
    @DisplayName("Ne devrait pas créer un etudiant  lorsque le cne est nul")
    public void testThrowRuntimeExceptionWhenPhoneNumberIsNull() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            etudiantManager.addEtudiant("Ahmad", "Ahmadi", null);
        });
    }

    @Test
    @DisplayName("Devrait créer un  etudiant ")
    @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Devrait fonctionner uniquement sur WINDOWS")
    public void testCreateContactOnMAC() {
        etudiantManager.addEtudiant("Ahmad", "Ahmadi", "D132404747");
        assertFalse(etudiantManager.getAllStudent().isEmpty());
        assertEquals(1, etudiantManager.getAllStudent().size());
    }
    


    @Nested
    class RepeatedTests {
        @DisplayName("Répétez le test de création d'etudiant 5 fois")
        @RepeatedTest(value = 5)
        public void TestContactCreationRepeatedly() {
            etudiantManager.addEtudiant("Ahmad", "Ahmadi", "D132404747");
            assertFalse(etudiantManager.getAllStudent().isEmpty());
            assertEquals(1, etudiantManager.getAllStudent().size());
        }
    }


    @Test
    @DisplayName("Le test doit être désactivé")
    @Disabled
    public void testBeDisabled() {
        throw new RuntimeException("Le test ne doit pas être exécuté");
    }


    @AfterEach
    public void tearDown() {
        System.out.println("Doit être exécuté après chaque test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Doit être exécuté à la fin du test");
    }
}