import java.util.ArrayList;
import java.util.Collection;


public class EtudiantManager {
    ArrayList etudiantList = new ArrayList();

    public void addEtudiant(String firstName, String lastName, String cne) {
        Etudiant etudaint = new Etudiant(firstName, lastName, cne);
        validateEtudiant(etudaint);
        checkIfEtudiantAlreadyExist(etudaint);
        etudiantList.add(etudaint);
    }

    public Collection<Etudiant> getAllStudent() {
        return etudiantList;
    }

    private void checkIfEtudiantAlreadyExist(Etudiant etudiant) {
        if (etudiantList.equals(generateKey(etudiant)))
            throw new RuntimeException("Le contact existe déjà");
    }

    private void validateEtudiant(Etudiant etudiant) {
        etudiant.validateFirstName();
        etudiant.validateLastName();
        etudiant.validateCNE();
    }

    private String generateKey(Etudiant etudiant) {
        return String.format("%s-%s", etudiant.getFirstName(), etudiant.getLastName());
    }

}
