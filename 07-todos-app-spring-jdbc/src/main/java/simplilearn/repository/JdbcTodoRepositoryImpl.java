package simplilearn.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import simplilearn.model.Todo;

@Repository(value = "todoRepository")
public class JdbcTodoRepositoryImpl implements TodoRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	protected JdbcTodoRepositoryImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//nested class 
	class TodoRowMapper implements RowMapper<Todo>{

		@Override
		public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
//			System.out.println(" Row No # " + rowNum);
			Todo  theTodo = new Todo();
			theTodo.setId(rs.getLong("id"));
			theTodo.setDescription(rs.getString("description"));
			theTodo.setUsername(rs.getString("username"));
			theTodo.setTargetDate(rs.getDate("targetDate"));
			theTodo.setDone(rs.getBoolean("isDone"));
			return theTodo;
		}
		
	}
	@Override
	public List<Todo> findAll() {
		String sql = "select * from todos";
		List<Todo> todoList = jdbcTemplate.query(sql, new TodoRowMapper());
		return todoList;
	}

	@Override
	public Todo findById(long theId) {
		String sql = "select * from todos where id = ?";
		Todo theTodo = jdbcTemplate.queryForObject(sql,  new TodoRowMapper(), theId);
		return theTodo;
	}

	@Override
	public Todo save(Todo theTodo) {
		String sql = "insert into todos (description,username,isDone) value (?,?,?)";
//		jdbcTemplate.update(sql, theTodo.getDescription(),theTodo.getUsername(),theTodo.isDone());
		
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
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

		return null;
	}

	@Override
	public Todo deleteById(long theId) {
		Todo theTodo = findById(theId);
		
		String sql = "delete from todos where id = ?";
		jdbcTemplate.update(sql, theId);
		
		return theTodo;
	}
	
	

}
