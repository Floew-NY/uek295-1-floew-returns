package dev.battino.backend.domains.returns;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/returns")
public class ReturnsController {    

    @Autowired
    private ReturnsRepository returnsRepository;

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    public ResponseEntity<String> getMethodName(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok().body(returnsRepository.findById(id).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok().body(returnsRepository.findAll().toString());
    }
}
