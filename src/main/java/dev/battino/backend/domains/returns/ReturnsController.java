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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/returns")
public class ReturnsController {

    @Autowired
    private ReturnsService returnsService;

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/")
    public ResponseEntity<List<Returns>> getAllReturns() {
        return ResponseEntity.ok().body(returnsService.findAll());
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    public ResponseEntity<Returns> getReturn(@PathVariable Integer id) {
        return ResponseEntity.ok().body(returnsService.findById(id));
    }

    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping("/")
    public ResponseEntity<Returns> postReturn(@Valid @RequestBody Returns entity) {
        Returns savedEntity = returnsService.create(entity);
        return ResponseEntity.created(null).body(savedEntity);
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<Returns> updateReturn(@PathVariable Integer id, @Valid @RequestBody Returns entity) {
        Returns returns = returnsService.update(entity, id);
        return ResponseEntity.ok().body(returns);
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteReturn(@PathVariable Integer id) {
        returnsService.deleteById(id);
        return ResponseEntity.ok().body("Return with id " + id + " has been deleted");
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
