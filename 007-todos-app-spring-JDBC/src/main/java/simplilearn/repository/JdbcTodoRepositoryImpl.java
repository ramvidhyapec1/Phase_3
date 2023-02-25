package simplilearn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import simplilearn.model.Todo;

@Repository(value="todoRepository")
public class JdbcTodoRepositoryImpl implements TodoRepository {
	
	//step 1
	private JdbcTemplate jdbctemplate;

	//step 2
	@Autowired
	public JdbcTodoRepositoryImpl(DataSource dataSource) {
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}
	
	//Nested Class - step 3
	class TodoRowMapper implements RowMapper<Todo> {
	
	@Override
	public Todo mapRow(ResultSet rs,int rowNum) throws SQLException{
			System.out.println("Row No : "+rowNum);
			Todo theTodo = new Todo();
			theTodo.setId(rs.getLong("id"));
			theTodo.setDescription(rs.getString("description"));
			theTodo.setUsername(rs.getString("username"));
			theTodo.setTargetDate(rs.getDate("targetDate"));
			theTodo.setDone(rs.getBoolean("isDone"));
			return theTodo;
		}
	}
	
	//step 4
	@Override
	public Todo save(Todo theTodo) {
		String sql = "insert into todos (description,username,isDone) value (?,?,?)";
//		jdbcTemplate.update(sql, theTodo.getDescription(),theTodo.getUsername(),theTodo.isDone());
		
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		
		jdbctemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, theTodo.getDescription());
				statement.setString(2, theTodo.getUsername());
				statement.setBoolean(3, theTodo.isDone());
				return statement;
			}
		},holder);
		
		long primaryKey = holder.getKey().longValue();
		System.out.println("ID " + primaryKey);

		return findById(primaryKey);
	}

	@Override
	public Todo findById(long theId) {
		String sql="select * from todos where id = ?";
		Todo theTodo = jdbctemplate.queryForObject(sql, new TodoRowMapper(), theId);
		return theTodo;
	}

	@Override
	public List<Todo> findAll() {
		String sql="select * from todos";
		List<Todo> todoList= jdbctemplate.query(sql, new TodoRowMapper()); 
		return todoList;
	}

	@Override
	public Todo deleteById(long theId) {
		
		Todo theTodo = findById(theId);
		
		String sql="delete from todos where id = ?";
		jdbctemplate.update(sql, theId);
		
		return theTodo;
	}
	
	
}
