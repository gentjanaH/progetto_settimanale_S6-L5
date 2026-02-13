package gentjanahani.progettou2w6d5.services;

import gentjanahani.progettou2w6d5.repository.ViaggioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ViaggioService {

    private final ViaggioRepository viaggioRepository;

    @Autowired
    public ViaggioService(ViaggioRepository viaggioRepository) {
        this.viaggioRepository = viaggioRepository;
    }
}
