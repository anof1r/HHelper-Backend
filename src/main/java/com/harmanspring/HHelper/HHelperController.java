package com.harmanspring.HHelper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.*;
import parse.ResponseItem;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HHelperController {


    private ArrayList<MaterialContent> materialList;

    private static final String jsonPath = "main_content.json";

    HHelperController() throws IOException {
        Gson gson = new Gson();
        Path fileName = Path.of(jsonPath);
        Type type = new TypeToken<ArrayList<MaterialContent>>() {
        }.getType();
        String result = Files.readString(fileName);
        materialList = gson.fromJson(result, type);
    }

    @GetMapping("/main_content")
    public ArrayList<MaterialContent> mainContent() {
        return materialList;
    }

    //for web form
    @GetMapping("/form")
    @ResponseBody
    public ArrayList<MaterialContent> addMaterial(@RequestParam String title,
                                                  String content,
                                                  int id, String hw,
                                                  String date) throws IOException {

        MaterialContent material = new MaterialContent();

        material.setTitle(title);
        material.setContent(content);
        material.setId(id);
        material.setHomeWork(hw);
        material.setDate(date);

        materialList.add(material);

        Gson gson = new Gson();
        String materialJson = gson.toJson(materialList);
        Path fileName = Path.of(jsonPath);
        Files.writeString(fileName, materialJson);
        return materialList;
    }
}
