package dev.yosukeee.mb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import dev.yosukeee.mb.model.Teacher;

@Mapper
public interface TeacherMapper {

	Long count();
	
	List<Teacher> selectAll(RowBounds rowBounds);
	
	Teacher selectById(Long id);
	
	int insert(Teacher teacher);
	
	int updateById(Teacher teacher);
	
	int deleteById(Long id);
}
