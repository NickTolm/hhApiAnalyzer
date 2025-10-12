package com.example.hhapianalyzer.dto.vacancies;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class VacancyDto {
    private String id;
    private String name;
    private boolean has_test;
    private boolean response_letter_required;
    private Area area;
    private Salary salary;
//    private SalaryRange salaryRange;
//    private Type type;
//    private Address address;
//    private String responseUrl;
//    private String sortPointDistance;
    private String published_at;
    private String created_at;
//    private boolean archived;
//    private String applyAlternateUrl;
//    private boolean showContacts;
//    private Object insiderInterview;
//    private String url;
//    private String alternateUrl;
//    private List<Object> relations;
//    private Employer employer;
//    private List<String> requirement;
//    private List<String> responsibility;
//    private Object contacts;
//    private Schedule schedule;
//    private List<WorkingDay> workingDays;
//    private List<WorkingTimeInterval> workingTimeIntervals;
//    private List<WorkingTimeMode> workingTimeModes;
//    private boolean acceptTemporary;
//    private List<Object> flyInFlyOutDuration;
    private List<WorkFormat> work_format;
    private List<WorkingHours> working_hours;
//    private List<WorkScheduleByDays> workScheduleByDays; // 5/2
//    private boolean nightShifts;
//    private List<ProfessionalRole> professionalRoles;
    private boolean accept_incomplete_resumes;
    private Experience experience;
//    private Employment employment;
//    private EmploymentForm employmentForm;
//    private boolean internship;
//    private String advResponseUrl;
//    private boolean isAdvVacancy;
//    private Object advContext;


//    @JsonProperty("experience")
//    private void setExperience(JsonNode experienceNode) {
//        if (experienceNode != null && experienceNode.has("id")) {
//            this.experience = experienceNode.get("id").asText();
//        }
//    }
}
