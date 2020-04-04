package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ResultSetHandler {
	
	/**
	 * 结果集处理
	 * @param rs
	 * @return
	 */
	public  ArrayList mapping(ResultSet rs) throws SQLException;
	

}
