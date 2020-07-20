package com.example.demo.model;

import lombok.Data;

import java.util.List;

/**
 * @author David Venable
 * @since Jul 13, 2020
 */
@Data
public class OkModel
{
    private String demoId;
    private List<Node> listOfNodes;
}
