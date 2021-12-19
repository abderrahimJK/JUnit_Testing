public class Etudiant {
    private String firstName;
    private String lastName;
    private String CNE;

    public Etudiant(String firstName, String lastName, String CNE) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNE = CNE;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getCNE() {
        return CNE;
    }

    public void validateFirstName() {
        if (this.firstName.isBlank())
            throw new RuntimeException("Le prénom ne peut pas être nul ou vide");
    }

    public void validateLastName() {
        if (this.lastName.isBlank())
            throw new RuntimeException("Le nom ne peut pas être nul ou vide");
    }

    public void validateCNE() {
        if (this.CNE.isBlank()) {
            throw new RuntimeException("Le CNE ne peut pas être nul ou vide");
        }

        if (this.CNE.length() != 10) {
            throw new RuntimeException("Le CNE doit comporter 1 lettre et 9 chiffres");
        }
        if (!this.CNE.matches("^[A-Z]{1}+[0-9]{9}")) {
            throw new RuntimeException("CNE Ne contient que des chiffres");
        }

    }
}
