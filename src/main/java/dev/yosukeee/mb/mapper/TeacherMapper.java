package dev.yosukeee.mb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dev.yosukeee.mb.model.Teacher;

@Mapper
public interface TeacherMapper {

	@Select("SELECT * FROM teacher")
	List<Teacher> selectAll();
	
	@Select({
		"SELECT * FROM teacher",
		"WHERE id = #{id}"
	})
	Teacher selectById(Long id);
	
	@Insert({
		"INSERT INTO teacher(name, email)",
		"VALUES (#{name}, #{email})"
	})
	int insert(Teacher teacher);
	
	@Update({
		"UPDATE teacher",
		"SET name = #{name}, email = #{email}",
		"WHERE id = #{id}"
	})
	int updateById(Teacher teacher);
	
	@Delete({
		"DELETE FROM teacher",
		"WHERE id = #{id}"
	})
	int deleteById(Long id);
}
