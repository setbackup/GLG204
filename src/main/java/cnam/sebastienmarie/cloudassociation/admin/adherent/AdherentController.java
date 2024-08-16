package cnam.sebastienmarie.cloudassociation.admin.adherent;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.sebastienmarie.cloudassociation.common.service.JWTResult;
import cnam.sebastienmarie.cloudassociation.common.adhesion.dao.AdhesionDAO;
import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;

@CrossOrigin
@RestController
@RequestMapping("/admin/adherent")
public class AdherentController {

    @Autowired
    JWTResult jwtResult;

    @Autowired
    AdhesionDAO adhesionDao;

    @GetMapping
    public ResponseEntity<?> getAdhesionByAssociation() {
        List<Adherent> lstAdherent = adhesionDao.findByAssociations(new Associations(jwtResult.getIdAssociation()));
        return ResponseEntity.ok().body(lstAdherent);
    }
}
