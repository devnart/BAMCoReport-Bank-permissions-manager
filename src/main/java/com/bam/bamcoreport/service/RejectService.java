package com.bam.bamcoreport.service;

import com.bam.bamcoreport.dto.model.RejectDto;
import com.bam.bamcoreport.dto.model.UserMembershipDto;
import com.bam.bamcoreport.dto.services.IMapDto;
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
import java.util.List;

@Service
public class RejectService {

    @Autowired
    private final RejectRepository rejectRepository;

    @Autowired
    IMapDto<Reject, RejectDto> rejectMapping;

    public RejectService(RejectRepository rejectRepository) {
        this.rejectRepository = rejectRepository;
    }

    public List<RejectDto> getAll() {
        List<Reject> rejects = rejectRepository.findAll();
        return rejectMapping.convertListToListDto(rejects, RejectDto.class);
    }

    public void addReject(Reject reject) {
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

    public void uploadFile(MultipartFile file) throws IOException {
        File convertFile = new
                File("C:\\Users\\admin\\Desktop\\BAMCoReport-Bank-permissions-manager\\src\\uploads" + file.getOriginalFilename());
        convertFile.createNewFile();

        try (FileOutputStream fout = new FileOutputStream(convertFile)) {
            fout.write(file.getBytes());
        } catch (Exception exe) {
            exe.printStackTrace();
        }

        System.out.println("File has uploaded successfully");
    }

    public void updateReject(Long id, Users userId) {

        Reject reject = rejectRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Reject with" + id + "does not exist"));

        reject.setTakenBy(userId);
    }

}
