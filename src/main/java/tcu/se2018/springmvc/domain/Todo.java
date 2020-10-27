package tcu.se2018.springmvc.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Todo {
    private String id;
    private boolean done;
    private String title;
    private LocalDateTime createDate;
}
