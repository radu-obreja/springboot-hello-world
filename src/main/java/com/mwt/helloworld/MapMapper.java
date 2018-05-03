package com.mwt.helloworld;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class MapMapper implements RowMapper<Map<String, Object>> {

	@Override
	public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, Object> row = new HashMap<String, Object>();
		for (int i=1; i <= rs.getMetaData().getColumnCount(); i++) {
			String columnName = rs.getMetaData().getColumnLabel(i);
			row.put(columnName.toLowerCase(), rs.getObject(i));
		}		
		return row;
	}

}
