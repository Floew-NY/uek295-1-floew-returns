package dev.battino.backend.domains.returns;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.net.URI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.URIEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/returns")
public class ReturnsController {    

    @Autowired
    private ReturnsService returnsService;


    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/")
    public ResponseEntity<String> getAllReturns() {
        return ResponseEntity.ok().body(returnsService.findAll().toString());
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    public ResponseEntity<Returns> getReturn(@PathVariable Integer id) {
            return ResponseEntity.ok().body(returnsService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Returns> postReturn(@Valid @RequestBody Returns entity, HttpServletRequest request) {
        Returns savedEntity = returnsService.save(entity);
        return ResponseEntity.created(null).body(savedEntity);
    }

}
