package com.example.hhapianalyzer.dto.AreaHhDto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AreaHhDto {
    private Integer id;
    private Integer parent_id;
    private String name;
    private List<AreaHhDto> areas;
    private String utc_offset;
    private Double lat;
    private Double lng;
}
