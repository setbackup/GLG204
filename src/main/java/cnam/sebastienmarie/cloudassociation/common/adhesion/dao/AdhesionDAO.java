package cnam.sebastienmarie.cloudassociation.common.adhesion.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import java.util.List;


public interface AdhesionDAO extends JpaRepository<Adherent, String>{

    Adherent findByEmail(String email);

    List<Adherent> findByAssociations(Associations associations);
    
}
