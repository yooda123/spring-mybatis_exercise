package dev.yosukeee.mb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.yosukeee.mb.mapper.TeacherMapper;
import dev.yosukeee.mb.model.Teacher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Transactional
public class TeacherService {

	private final TeacherMapper mapper;
	
	public List<Teacher> findAll() {
		return mapper.selectAll();
	}
	
	public Teacher findById(Long id) {
		return mapper.selectById(id);
	}
	
	public void save(Teacher teacher) {
		if (teacher.getId() == null) {
			mapper.insert(teacher);
		} else {
			mapper.updateById(teacher);
		}
	}
	
	public void deleteById(Long id) {
		mapper.deleteById(id);
	}
	
}
