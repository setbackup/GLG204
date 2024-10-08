package cnam.sebastienmarie.cloudassociation.common.campagne.dao;

import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;
import cnam.sebastienmarie.cloudassociation.common.campagne.domain.CampagneDons;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CampagneDonsDAO extends JpaRepository<CampagneDons, String> {

   List<CampagneDons> findByAssociation(Associations association);

   List<CampagneDons> findByAssociation(Optional<Associations> association);
   
   //@Modifying
   //@Query(value ="DELETE FROM campagnes_dons c WHERE c.id= ?1", nativeQuery = true)
   //void deleteById(String idCampagne);  
   void deleteBy(String idCampagne);

}
