package gentjanahani.progettou2w6d5.services;

import gentjanahani.progettou2w6d5.entities.Dipendente;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import gentjanahani.progettou2w6d5.exceptions.BadRequestException;
import gentjanahani.progettou2w6d5.exceptions.NotFoundException;
import gentjanahani.progettou2w6d5.payloads.DipendenteDTO;
import gentjanahani.progettou2w6d5.repository.DipendenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;
    private final Cloudinary cloudinaryUploader;

    @Autowired
    public DipendenteService(DipendenteRepository dipendenteRepository, Cloudinary cloudinaryUploader) {
        this.dipendenteRepository = dipendenteRepository;
        this.cloudinaryUploader = cloudinaryUploader;
    }

    public Dipendente save(DipendenteDTO payload) {

        this.dipendenteRepository.findByEmail(payload.mail()).ifPresent(dipentente -> {
            throw new BadRequestException("L'email " + dipentente.getEmail() + "  è già in uso!");
        });

        this.dipendenteRepository.findByUsername(payload.username()).ifPresent(dipentente -> {
            throw new BadRequestException("Lo username" + dipentente.getUsername() + "  è già in uso!");
        });

        Dipendente newDipendente = new Dipendente(payload.username(), payload.name(), payload.surname(), payload.mail());
        newDipendente.setAvatar("https://ui-avatars.com/api?name=" + payload.surname());

        Dipendente savedDip = this.dipendenteRepository.save(newDipendente);
        log.info("Il dipendente con id {} è stato salvato correttamente.", payload.surname());

        return savedDip;
    }

    public Dipendente findDipendenteById(UUID idDipendente) {
        Dipendente dipendente = dipendenteRepository.findByIdDipendente(idDipendente);
        if (dipendente == null) throw new NotFoundException(idDipendente);
        return dipendente;
    }

    public String uploadAvatar(MultipartFile file) {
        if (file.isEmpty()) throw new BadRequestException("Il file è vuoto");
        if (file.getSize() > 2_000_000) throw new BadRequestException("Il file è troppo grande");

        String contentType = file.getContentType();
        if (contentType == null || !(contentType.equals("image/jpeg") || contentType.equals("image/png") || contentType.equals("image/gif"))) {
            throw new BadRequestException("Sono ammessi solo file JPG, PNG, o GIF");
        }
        
        try {
            Map result = cloudinaryUploader.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imgUrl = (String) result.get("secure_url");

            return imgUrl;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
