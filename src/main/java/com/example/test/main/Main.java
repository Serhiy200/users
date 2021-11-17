package com.example.test.main;

import com.example.test.dao.UsersDAO;
import com.example.test.model.Users;
import com.example.test.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Main {

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public String index() {
        return "main";
    }

    @GetMapping("/regist")
    public String getRegistration() {
        return "regist";
    }

    @PostMapping("/regist")
    public String postRegistration(@ModelAttribute("user") Users users, Model model) {
        usersDAO.regUser(users);
        model.addAttribute("user", users);
        return "user";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("user") Users users, Model model) {
        Users userData = null;
        try {
            userData = usersDAO.login(users);
            model.addAttribute("user", userData);
        } catch (Exception e) {
            return "main";
        }
        return "user";
    }

    @GetMapping("/list-users")
    public String getUsersList(Model model) {
        model.addAttribute("users", usersDAO.getAllUsers());
        return "users-list";
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", usersDAO.getUserById(id));
        return "user";
    }

    @PostMapping("/save-file")
    public String saveFileToS3(@RequestParam("file") MultipartFile file, Model model) {
        // validate file
        if (file.isEmpty()) {
            model.addAttribute("error", "File is not able");
        } else {
            fileService.save(file);
        }
        return "redirect:/";
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = fileService.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}
