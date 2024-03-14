package dev.battino.backend.domains.returns;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.dao.DataIntegrityViolationException;

@RestController
@RequestMapping("/returns")
public class ReturnsController {

    @Autowired
    private ReturnsService returnsService;

    @Operation(description = "Get all returns", summary = "Get all returns")
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/")
    public ResponseEntity<List<Returns>> getAllReturns() {
        return ResponseEntity.ok().body(returnsService.findAll());
    }

    @Operation(description = "Get a return by id", summary = "Get a return")
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/{id}")
    public ResponseEntity<Returns> getReturn(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok().body(returnsService.findById(id));
    }

    @Operation(description = "Create a return", summary = "Create a return")
    @PreAuthorize("hasAuthority('CREATE')")
    @PostMapping("/")
    public ResponseEntity<Returns> postReturn(@Valid @RequestBody Returns entity) {
        Returns savedEntity = returnsService.create(entity);
        return ResponseEntity.created(null).body(savedEntity);
    }

    @Operation(description = "Update a return by id", summary = "Update a return")
    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping("/{id}")
    public ResponseEntity<Returns> updateReturn(@Valid @PathVariable Integer id, @Valid @RequestBody Returns entity) {
        Returns returns = returnsService.update(entity, id);
        return ResponseEntity.ok().body(returns);
    }

    @Operation(description = "Delete a return by id", summary = "Delete a return")
    @PreAuthorize("hasAuthority('DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReturn(@Valid @PathVariable Integer id) {
        returnsService.deleteById(id);
        return ResponseEntity.ok().body("Return with id " + id + " has been deleted");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Invalid request method");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getBindingResult().getFieldError().getField() + " is invalid: "
                + e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        String errorMessage = "The requested resource was not found.";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getCause().getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Data integrity violation: " + e.getCause().getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body("Invalid request body: " + e.getCause().getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

}
