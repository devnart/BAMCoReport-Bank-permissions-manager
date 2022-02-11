package com.bam.bamcoreport.controller;

import com.bam.bamcoreport.dto.model.RejectDto;
import com.bam.bamcoreport.entity.Reject;
import com.bam.bamcoreport.service.RejectService;
import com.google.common.net.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/reject")
public class RejectController {

    private static final Logger log = LoggerFactory.getLogger(RejectController.class);
    private final RejectService rejectService;

    @Autowired
    public RejectController(RejectService rejectService) {
        this.rejectService = rejectService;
    }

    @GetMapping
    public List<RejectDto> getRejects(){
        log.info("Showing rejects list");
        return rejectService.getAll();
    }

    @PostMapping
    public void addNewReject(@RequestParam Map<String,String> reject, @RequestParam("file") MultipartFile file) throws IOException {
        log.info("Reject added");
        rejectService.addReject(reject,file);
    }

    @DeleteMapping(path = "{id}")
    public void deleteReject(@PathVariable("id") Long id){
        log.warn("Reject deleted");
        rejectService.deleteReject(id);
    }
}
