package com.example.ris.services.implementation;

import com.example.ris.models.entities.Lokacija;
import com.example.ris.models.entities.Status;
import com.example.ris.repositories.StatusRepository;
import com.example.ris.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImplementation implements StatusService {
    @Autowired
    private StatusRepository _statusRepository;
    @Override
    public List<Status> getStatusi() {
        List<Status> statusi = _statusRepository.getStatusi();
        return statusi.stream().map(Status::new).collect(Collectors.toList());
    }
}
