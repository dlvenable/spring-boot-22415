package com.example.demo.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BrokenModel
{
    private Map<String, List<Node>> myMap;

    private String demoId;
}
