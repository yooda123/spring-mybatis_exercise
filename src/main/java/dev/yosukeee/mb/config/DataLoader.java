package dev.yosukeee.mb.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.yosukeee.mb.model.Teacher;
import dev.yosukeee.mb.service.TeacherService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final TeacherService service;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Teacher teacher = new Teacher();
            teacher.setName("テスト");
            teacher.setEmail("test@example.com");
            service.save(teacher);
        }
    }
}
