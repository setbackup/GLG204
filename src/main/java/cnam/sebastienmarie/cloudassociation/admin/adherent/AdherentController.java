package cnam.sebastienmarie.cloudassociation.admin.adherent;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/admin/adherent")
public class AdherentController {

    @GetMapping
    public ResponseEntity<?> getAdhesionByAssociation() {
        return ResponseEntity.ok().body("OK");
    }
 
    
}
