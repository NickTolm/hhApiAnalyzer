package com.example.hhapianalyzer.entity.vacancy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Searcher {
    private String name;
    private Area area;
    @JsonProperty("only_with_salary")
    private boolean onlyWithSalary;
    private Salary salary;
    @JsonProperty("published_at")
    private String publishedAt;
    @JsonProperty("created_at")
    private String createdAt;
    private boolean acceptIncompleteResumes;
    private Experience experience;
    /*
    "experience": [
    {
      "id": "noExperience",
      "name": "Нет опыта"
    },
    {
      "id": "between1And3",
      "name": "От 1 года до 3 лет"
    },
    {
      "id": "between3And6",
      "name": "От 3 до 6 лет"
    },
    {
      "id": "moreThan6",
      "name": "Более 6 лет"
    }
    */
    @JsonProperty("employment_form")
    private String employmentForm;
    /*
    "employment_form": [
    {
      "id": "FULL",
      "name": "Полная"
    },
    {
      "id": "PART",
      "name": "Частичная"
    },
    {
      "id": "PROJECT",
      "name": "Проект или разовое задание"
    },
    {
      "id": "FLY_IN_FLY_OUT",
      "name": "Вахта"
    }
  ],
     */
    @JsonProperty("work_schedule_by_days")
    private String workScheduleByDays;
    /*
        {
      "id": "SIX_ON_ONE_OFF",
      "name": "6/1"
    },
    {
      "id": "FIVE_ON_TWO_OFF",
      "name": "5/2"
    },
    {
      "id": "FOUR_ON_FOUR_OFF",
      "name": "4/4"
    },
    {
      "id": "FOUR_ON_THREE_OFF",
      "name": "4/3"
    },
    {
      "id": "FOUR_ON_TWO_OFF",
      "name": "4/2"
    },
    {
      "id": "THREE_ON_THREE_OFF",
      "name": "3/3"
    },
    {
      "id": "THREE_ON_TWO_OFF",
      "name": "3/2"
    },
    {
      "id": "TWO_ON_TWO_OFF",
      "name": "2/2"
    },
    {
      "id": "TWO_ON_ONE_OFF",
      "name": "2/1"
    },
    {
      "id": "ONE_ON_THREE_OFF",
      "name": "1/3"
    },
    {
      "id": "ONE_ON_TWO_OFF",
      "name": "1/2"
    },
    {
      "id": "WEEKEND",
      "name": "По выходным"
    },
    {
      "id": "FLEXIBLE",
      "name": "Свободный"
    },
    {
      "id": "OTHER",
      "name": "Другое"
    }
  ],
     */
    @JsonProperty("work_format")
    private String workFormat;
    /*
    "work_format": [
    {
      "id": "ON_SITE",
      "name": "На месте работодателя"
    },
    {
      "id": "REMOTE",
      "name": "Удалённо"
    },
    {
      "id": "HYBRID",
      "name": "Гибрид"
    },
    {
      "id": "FIELD_WORK",
      "name": "Разъездной"
    }
  ],
  */
  @JsonProperty("resume_employment_form")
  private String resumeEmploymentForm;
  /*
    {
      "id": "FULL",
      "name": "Постоянная работа"
    },
    {
      "id": "PART_TIME",
      "name": "Подработка"
    },
    {
      "id": "INTERNSHIP",
      "name": "Стажировка"
    },
    {
      "id": "VOLUNTEER",
      "name": "Волонтёрство"
    }
   */
    private String education;
    /*
    not_required_or_not_specified - не требуется или не указано
    special_secondary - среднее специальное
    higher - высшее
     */
}
