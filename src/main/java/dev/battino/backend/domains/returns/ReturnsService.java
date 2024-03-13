package dev.battino.backend.domains.returns;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnsService {
    
    @Autowired
    private ReturnsRepository returnsRepository;

    public Returns findById(Integer id) {
        return returnsRepository.findById(id).orElseThrow();
    }

    public Returns save(Returns returns) {
        return returnsRepository.save(returns);
    }

    public List<Returns> findAll() {
        return returnsRepository.findAll();
    }

    public void deleteById(Integer id) {
        returnsRepository.deleteById(id);
    }

    public void update(Returns returns) {
        returnsRepository.save(returns);
    }

    //get id by name
    public Integer getIdByName(String name) {
        for(Returns returns : findAll()) {
            if(returns.getReason().equals(name)) {
                return returns.getId();
            }
        }
        return null;
    }
}
