package cnam.sebastienmarie.cloudassociation.admin.adherent.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;
import java.text.SimpleDateFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cnam.sebastienmarie.cloudassociation.common.service.JWTResult;
import cnam.sebastienmarie.cloudassociation.admin.adherent.dto.AdherentDTO;
import cnam.sebastienmarie.cloudassociation.common.adhesion.dao.AdhesionDAO;
import cnam.sebastienmarie.cloudassociation.common.adhesion.domain.Adherent;
import cnam.sebastienmarie.cloudassociation.common.association.domain.Associations;

@CrossOrigin(origins = "*")
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

    @PostMapping
    public ResponseEntity<?> saveAdhesion(@Valid @RequestBody AdherentDTO adherentDTO) {

        SimpleDateFormat date = new SimpleDateFormat("yyyyMMDD");
        String uuid = UUID.randomUUID().toString();
      
        String idAdhesion = "AD".concat(date.format(new Date()))
                                  .concat(uuid.substring(25, 36));

        adhesionDao.save(new Adherent(idAdhesion, 
                                        adherentDTO.getNom(), 
                                        adherentDTO.getPrenom(),
                                        adherentDTO.getEmail(),
                                        adherentDTO.getPassword(),
                                        adherentDTO.getAdresse(),
                                        adherentDTO.getVille(),
                                        adherentDTO.getCode_postal(),
                                        new Associations(jwtResult.getIdAssociation())));

        return ResponseEntity.ok().body("Adherent inscrit");
    }
    
}
