package com.cydeo.model;

import lombok.Data;

@Data  // model class never used as a component
public class Comment {
    private String author;
    private String text;
}
