package com.example.collectiondb.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.collectiondb.entity.studentEntity;

@Service
public class studentService {
    
    Map<Long, studentEntity> studentData=new HashMap<>();

    public studentEntity saveData(studentEntity student){
        studentData.put(student.getId(), student);
        return student;
    }
}
