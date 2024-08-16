package cnam.sebastienmarie.cloudassociation.inscription.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AssociationDTO {

    @NotNull(message="Le nom de l'association n'est pas présent")
    @NotBlank(message = "Le nom l'association est vide")
    private String nom;
    
    @NotNull(message="Le adresse l'association n'est pas présent")
    @NotBlank(message = "Le adresse l'association est vide")
    private String adresse;

    @NotNull(message="Le codepostal l'association n'est pas présent")
    @NotBlank(message = "Le codepostal l'association est vide")
    private String codepostal;

    @NotNull(message="Le ville l'association n'est pas présent")
    @NotBlank(message = "Le ville l'association est vide")
    private String ville;


    public AssociationDTO(@JsonProperty("nom") String nom, 
                            @JsonProperty("prenom") String prenom,
                            @JsonProperty("adresse") String adresse, 
                            @JsonProperty("codepostal") String codepostal, 
                            @JsonProperty("ville") String ville 
                            ){
        this.nom = nom;
        this.adresse = adresse;
        this.codepostal = codepostal;
        this.ville = ville;
    }
                            

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return this.codepostal;
    }

    public void setCodePostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}
