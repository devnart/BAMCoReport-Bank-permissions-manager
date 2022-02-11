package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.ProfileDto;
import com.bam.bamcoreport.dto.model.RejectDto;
import com.bam.bamcoreport.dto.model.UserDto;
import com.bam.bamcoreport.dto.model.UserMembershipDto;
import com.bam.bamcoreport.dto.services.IMapDto;
import com.bam.bamcoreport.dto.services.MapString;
import com.bam.bamcoreport.entity.Profile;
import com.bam.bamcoreport.entity.Reject;
import com.bam.bamcoreport.entity.UserMembership;
import com.bam.bamcoreport.entity.Users;
import com.bam.bamcoreport.repository.RejectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
public class RejectService {

    @Autowired
    private final RejectRepository rejectRepository;

    @Autowired
    IMapDto<Reject, RejectDto> rejectMapping;

    @Autowired
    MapString<Map<String, String>, Reject> toReject;

    private final Path root = Paths.get("uploads");

    public RejectService(RejectRepository rejectRepository) {
        this.rejectRepository = rejectRepository;
    }

    public List<RejectDto> getAll() {
        List<Reject> rejects = rejectRepository.findAll();
        return rejectMapping.convertListToListDto(rejects, RejectDto.class);
    }

    public void addReject(Map<String, String> params, MultipartFile file) throws IOException {
        Reject reject = toReject.convertToEntity(params, Reject.class);

        File convertFile = new File(root + "/" + file.getOriginalFilename());
        convertFile.createNewFile();

        try (FileOutputStream outputStream = new FileOutputStream(convertFile)) {
            outputStream.write(file.getBytes());
            reject.setFile(convertFile.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("File has uploaded successfully " + convertFile);

        rejectRepository.save(reject);
    }


    public RejectDto getById(Long id) {
        Reject reject = rejectRepository.findById(id).get();
        return rejectMapping.convertToDto(reject, RejectDto.class);
    }

    public void deleteReject(Long id) {

        boolean exists = rejectRepository.existsById(id);

        if (!exists) {
            throw new IllegalStateException("Id not found");
        }
        rejectRepository.deleteById(id);
    }

    public void updateReject(Long id, Users userId) {

        Reject reject = rejectRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Reject with" + id + "does not exist"));

        reject.setTakenBy(userId);
    }

}
