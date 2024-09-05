package cnam.sebastienmarie.cloudassociation.common.campagne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cnam.sebastienmarie.cloudassociation.common.campagne.domain.Donnation;

public interface DonsDAO  extends JpaRepository<Donnation, String> {

    @Query(value ="DELETE FROM donnations d WHERE d.id_campagne = ?1", nativeQuery = true)
    void deleteByIdCampagnesDons(String IdCampagneDons);
    
}
