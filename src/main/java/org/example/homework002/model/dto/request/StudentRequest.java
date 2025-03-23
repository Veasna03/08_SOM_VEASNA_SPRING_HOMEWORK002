package org.example.homework002.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    private String name;
    private String email;
    private String phone_number;
    private List<Integer> course_id;

}
