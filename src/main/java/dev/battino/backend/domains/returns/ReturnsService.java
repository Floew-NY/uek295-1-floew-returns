package dev.battino.backend.domains.returns;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnsService {

    @Autowired
    private ReturnsRepository returnsRepository;

    public Returns findById(Integer id) {
        return returnsRepository.findById(id).orElseThrow();
    }

    public Returns create(Returns returns) {

        returns.setId(null);
        return returnsRepository.save(returns);
    }

    public Returns update(Returns entity, Integer id) {
        returnsRepository.findById(id).orElseThrow();
        entity.setId(id);
        return returnsRepository.save(entity);
    }

    public List<Returns> findAll() {
        return returnsRepository.findAll();
    }

    public void deleteById(Integer id) {
        if (returnsRepository.findById(id) == null)
            throw new NoSuchElementException("Return with id " + id + " does not exist");
        returnsRepository.deleteById(id);
    }
}
