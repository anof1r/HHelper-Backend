package com.harmanspring.HHelper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import parse.Info;
import parse.LinksItem;
import parse.ResponseItem;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HHelperController {


    private final ArrayList<MaterialContent> materialList;
    private final Info information;

    private static final String jsonPath = "main_content.json";
    private static final String InfoJsonPath = "information.json";

    HHelperController() throws IOException {
        Gson gson = new Gson();
        Path fileName = Path.of(jsonPath);
        Type type = new TypeToken<ArrayList<MaterialContent>>() {
        }.getType();
        String result = Files.readString(fileName);
        materialList = gson.fromJson(result, type);

        Path fileNameInf = Path.of(InfoJsonPath);
        Type typeInf = new TypeToken<Info>() {
        }.getType();
        String resultInf = Files.readString(fileNameInf);
        information = gson.fromJson(resultInf, typeInf);
    }

    @GetMapping("/main_content")
    public ArrayList<MaterialContent> mainContent() {
        return materialList;
    }

    @GetMapping("/information")
    public Info information() {
        return information;
    }

    //for web form
    @GetMapping("/form")
    @ResponseBody
    public ArrayList<MaterialContent> addMaterial(String title,
                                                  String content,
                                                  String imgId,
                                                  int id,
                                                  String hw,
                                                  String date) throws IOException {

        MaterialContent material = new MaterialContent();

        material.setTitle(title);
        material.setContent(content);
        material.setId(id);
        material.setHomeWork(hw);
        material.setDate(date);
        material.setImageId(imgId);
        materialList.add(material);
        Gson gson = new Gson();
        String materialJson = gson.toJson(materialList);
        Path fileName = Path.of(jsonPath);
        Files.writeString(fileName, materialJson);
        return materialList;
    }

    @GetMapping("/updateInfo")
    @ResponseBody
    public Info createInfo(String literature,
                           String schedule, String links) throws IOException {

        for (String linkLine : links.split("\r\n")) {
            LinksItem link = new LinksItem();
            link.setHref(linkLine.split(" ", 2)[0]);
            link.setDescription(linkLine.split(" ", 2)[1]);
            information.getLinks().add(link);
        }
        for (String book : literature.split("\r\n")) {
            information.getLiterature().add(book);
        }
        information.setSchedule(schedule);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String infoJson = gson.toJson(information);
        Path fileName = Path.of(InfoJsonPath);
        Files.writeString(fileName, infoJson);
        return information;
    }
    @GetMapping("/web_view")
    public String showForm() throws IOException {
        return Files.readString(Path.of("form.html"));
    }
}
