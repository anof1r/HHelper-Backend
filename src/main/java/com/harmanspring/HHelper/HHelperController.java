package com.harmanspring.HHelper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import parse.Info;
import parse.LinksItem;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

@RestController
public class HHelperController {

    private final ArrayList<MaterialContent> materialList;
    private final Info information;
    private final ArrayList<Contacts> contactlList;

    private static final String jsonPath = "main_content.json";
    private static final String InfoJsonPath = "information.json";
    private static final String ContactJsonPath = "contacts.json";

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

        Path fileNameC = Path.of(ContactJsonPath);
        Type typeCon = new TypeToken<ArrayList<Contacts>>() {
        }.getType();
        String resultCon = Files.readString(fileNameC);
        contactlList = gson.fromJson(resultCon, typeCon);
    }

    @GetMapping("/main_content")
    public ArrayList<MaterialContent> mainContent() {
        return materialList;
    }

    @GetMapping("/get_contacts")
    public ArrayList<Contacts> contacts() {
        return contactlList;
    }

    @GetMapping("/information")
    public Info information() {
        return information;
    }

    @PostMapping("/addLecture")
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
        //materialList.sort();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String materialJson = gson.toJson(materialList);
        Path fileName = Path.of(jsonPath);
        Files.writeString(fileName, materialJson);
        return materialList;
    }

    @PostMapping("/editLecture")
    public ArrayList<MaterialContent> editMaterial(String title,
                                                   String content,
                                                   String imgId,
                                                   int id,
                                                   String hw,
                                                   String date) throws IOException{
        MaterialContent lecture = new MaterialContent();

        lecture.setTitle(title);
        lecture.setContent(content);
        lecture.setId(id);
        lecture.setHomeWork(hw);
        lecture.setDate(date);
        lecture.setImageId(imgId);
        materialList.removeIf(material -> material.getId().equals(id));
        materialList.add(lecture);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String materialJson = gson.toJson(materialList);
        Path fileName = Path.of(jsonPath);
        Files.writeString(fileName, materialJson);
        return materialList;
    }

    @PostMapping("/deleteLecture")
    public void deleteMaterial (int id) throws IOException {
        materialList.removeIf(material -> material.getId().equals(id));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String materialJson = gson.toJson(materialList);
        Path fileName = Path.of(jsonPath);
        Files.writeString(fileName, materialJson);
    }

    @PostMapping("/updateInfo")
    public Info updateInfo(String literature,
                           String schedule, String links) throws IOException {


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String infoJson = gson.toJson(information);
        Path fileName = Path.of(InfoJsonPath);
        Files.writeString(fileName, "");

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

        Files.writeString(fileName, infoJson);
        return information;
    }

}
