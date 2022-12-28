package springboot_react.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot_react.todo.dto.ResponseDTO;
import springboot_react.todo.dto.TestRequestBodyDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String testController() {
        return "Hello World!";
    }
//    @GetMapping("/testRequestParam")
//    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
//        return "Hello World ! ID " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
//    }
    @GetMapping("/testRequestBody")
    public ResponseDTO<String>  testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }
    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status 200를 원한다면
        // ResponseEntity.badRequest().body(response); 사용
        // http status를 400로 설정.
        return ResponseEntity.badRequest().body(response);
    }
}