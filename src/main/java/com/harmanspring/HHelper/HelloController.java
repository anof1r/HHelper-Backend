package com.harmanspring.HHelper;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import parse.Response;
import parse.ResponseItem;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.awt.SystemColor.text;

@RestController
public class HelloController {


    public MaterialContent material = new MaterialContent();
    public ArrayList<MaterialContent> materialList = new ArrayList<>();
    public Gson gson = new Gson();
    public String jsonPath = "F:\\HARMANint\\HHelperSpring\\main_content.json";
    public List<ResponseItem> newList;

    //If android tells about ExceptionOutOfBound click this first

    @GetMapping("/main_content")
    public ArrayList<MaterialContent> mainContent() {
        return materialList;
    }

    //for web form
    @GetMapping("/getFromForm")
    @ResponseBody
    public ArrayList<MaterialContent> getFromForm(@RequestParam String title,
                                                  String content,
                                                  int id, String hw,
                                                  String date) throws IOException {

        material.setTitle(title);
        material.setContent(content);
        material.setId(id);
        material.setHomeWork(hw);
        material.setDate(date);
        materialList.add(material);
        String materialJson = gson.toJson(materialList);
        //BufferedWriter writer = new BufferedWriter(new FileWriter(jsonPath));
        //writer.write(materialJson);
        //writer.close();
        Path fileName = Path.of("main_content.json");
        Files.writeString(fileName, materialJson);
        String actual = Files.readString(fileName);
        return materialList;
    }
    @GetMapping("/read")
    public String read() throws IOException {
        Path fileName = Path.of("main_content.json");
        String content  = gson.toJson(materialList);
        //Files.writeString(fileName, content);
        String actual = Files.readString(fileName);
       return actual;
    }

}
