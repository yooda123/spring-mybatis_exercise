package dev.yosukeee.mb.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Teacher> findAll(Pageable pageable) {
		RowBounds rowBounds = new RowBounds((int) pageable.getOffset(), pageable.getPageSize());
		List<Teacher> teachers = mapper.selectAll(rowBounds);
		
		Long total = mapper.count();
		return new PageImpl<>(teachers, pageable, total);
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
