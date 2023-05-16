package com.hngy.controller;

import com.github.pagehelper.PageInfo;
import com.hngy.entity.File;
import com.hngy.entity.User;
import com.hngy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * @author 6-126
 * @date 2023/5/3 01:53
 */
@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/file")
    public String fileInfo(@RequestParam(defaultValue = "1", required = false) Integer pageNum, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        PageInfo<File> pageInfo = fileService.page(user.getUsername(), pageNum);
        model.addAttribute("pageInfo", pageInfo);
        return "fileInfo";
    }

    @GetMapping("/file/add")
    public String add() {
        return "addFile";
    }

    @PostMapping("/file/handleAdd")
    public String handleAdd(MultipartFile file, String title, HttpSession session, RedirectAttributes model) {
        User user = (User) session.getAttribute("user");
        String filename = file.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("file");
        String finalPath = realPath + java.io.File.separator + filename;
        try {
            file.transferTo(new java.io.File(finalPath));
            File fileEntity = new File();
            fileEntity.setUsername(user.getUsername());
            fileEntity.setTitle(title);
            fileEntity.setName(filename);
            fileEntity.setContentType(file.getContentType());
            fileEntity.setSize(file.getSize() + "");
            fileEntity.setFilePath(finalPath);
            fileService.addFile(fileEntity);
            model.addFlashAttribute("msg", "添加成功!");
        } catch (IOException e) {
            model.addFlashAttribute("msg", "添加失败!");
        }
        return "redirect:/file/add";
    }

    @GetMapping("/file/download")
    public String download() {
        return "fileDownload";
    }

    @GetMapping("/file/handleDownload")
    public ResponseEntity<byte[]> handleDownload(@RequestParam String title, HttpSession session, RedirectAttributes model) throws IOException {
        User user = (User) session.getAttribute("user");
        File file = fileService.getFile(user.getUsername(), title);
        if (Objects.isNull(file)) {
            throw new RuntimeException("文件不存在!");
        }
        String realPath = session.getServletContext().getRealPath("file" + java.io.File.separator + file.getName());
        FileInputStream inputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=" + file.getName());
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        inputStream.close();
        return responseEntity;
    }

    @GetMapping("/file/delete")
    public String delete() {
        return "fileDelete";
    }

    @GetMapping("/file/handleDelete")
    public String handleDelete(@RequestParam String title, HttpSession session, RedirectAttributes model) {
        User user = (User) session.getAttribute("user");
        File file = fileService.getFile(user.getUsername(), title);
        if (Objects.isNull(file)) {
            model.addFlashAttribute("msg", "文件不存在，删除失败!");
        } else {
            String realPath = session.getServletContext().getRealPath("file" + java.io.File.separator + file.getName());
            new java.io.File(realPath).delete();
            fileService.deleteFile(user.getUsername(), title);
            model.addFlashAttribute("msg", "删除成功!");
        }

        return "redirect:/file/delete";
    }
}
