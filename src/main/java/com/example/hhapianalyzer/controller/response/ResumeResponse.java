package com.example.hhapianalyzer.controller.response;

import com.example.hhapianalyzer.dto.ResumeDto;
import lombok.Data;

import java.util.List;

@Data
public class ResumeResponse {
    private List<ResumeDto> items;
    private int found;
    private int pages;
    private int perPage;
    private int page;
}
