package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.entity.PublisherEntity;
import bip.online.biplio2023.repository.CityRepo;
import bip.online.biplio2023.repository.PublisherRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Validated
public class PublisherService {
    private final PublisherRepo repo;
    public List<PublisherEntity> findAll(){
        return repo.findAll();
    }
    public Optional<PublisherEntity> findById(Long id){
        return repo.findById(id);
    }
    public PublisherEntity save (@Valid PublisherEntity data){
        return  repo.save(data);
    }
    public void update (PublisherEntity data){
        repo.save(data);
    }
}
