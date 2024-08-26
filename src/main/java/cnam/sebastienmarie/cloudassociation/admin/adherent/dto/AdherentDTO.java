package cnam.sebastienmarie.cloudassociation.admin.adherent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AdherentDTO {

    @NotNull(message="Le nom n'est pas présent")
    @NotBlank(message = "Le nom est vide")
    private String nom;
    
    @NotNull(message="Le prenom n'est pas présent")
    @NotBlank(message = "Le prenom est vide")
    private String prenom;

    @NotNull(message="L'email' n'est pas présent")
    @NotBlank(message = "L'email'est vide")
    private String email;

    @NotNull(message="Le password n'est pas présent")
    @NotBlank(message = "Le password est vide")
    private String password;

    @NotNull(message="L'adresse n'est pas présent")
    @NotBlank(message = "L'adresse est vide")
    private String adresse;

    @NotNull(message="La ville n'est pas présent")
    @NotBlank(message = "La ville est vide")
    private String ville;

    @NotNull(message="Le code postal n'est pas présent")
    @NotBlank(message = "Le code postal est vide")
    private String code_postal;

    public AdherentDTO(@JsonProperty("nom") String nom,
                        @JsonProperty("prenom") String prenom,
                        @JsonProperty("email") String email,
                        @JsonProperty("password") String password,
                        @JsonProperty("adresse") String adresse,
                        @JsonProperty("ville") String ville,
                        @JsonProperty("code_postal") String code_postal){
        
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.adresse = adresse;
        this.ville = ville;
        this.code_postal = code_postal;
    }

    public String toString(){
        return "Adhesion : {"+
            "\nnom : "+this.nom+
            "\nprenom: "+this.prenom+
            "\nemail: "+this.email+
            "\nadresse: "+this.adresse+
            "\nville: "+this.ville+
            "\ncode_postal: "+this.code_postal+
        "\n}";
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return this.code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }
}
