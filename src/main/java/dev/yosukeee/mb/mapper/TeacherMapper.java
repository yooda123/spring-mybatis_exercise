package dev.yosukeee.mb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.yosukeee.mb.model.Teacher;

@Mapper
public interface TeacherMapper {

	List<Teacher> selectAll();
	
	Teacher selectById(Long id);
	
	int insert(Teacher teacher);
	
	int updateById(Teacher teacher);
	
	int deleteById(Long id);
}
