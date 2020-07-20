package com.example.demo;

import com.example.demo.model.BrokenModel;
import com.example.demo.model.Node;
import com.example.demo.model.OkModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author David Venable
 * @since Jul 13, 2020
 */
@RestController
@Slf4j
public class DemoController
{
    @GetMapping("broken")
    BrokenModel getBrokenModel(@RequestHeader HttpHeaders httpHeaders)
    {
        log.info("Accept: {}", httpHeaders.getAccept().stream().map(MimeType::toString).collect(Collectors.joining(", ")));

        BrokenModel brokenModel = new BrokenModel();
        brokenModel.setDemoId(UUID.randomUUID().toString());
        Map<String, List<Node>> nodeMap = new HashMap<>();
        nodeMap.put(UUID.randomUUID().toString(), Collections.singletonList(new Node()));
        brokenModel.setMyMap(nodeMap);

        return brokenModel;
    }

    @GetMapping("ok")
    OkModel getOkModel()
    {
        OkModel okModel = new OkModel();
        okModel.setDemoId(UUID.randomUUID().toString());

        okModel.setListOfNodes(Collections.singletonList(new Node()));

        return okModel;
    }
}
