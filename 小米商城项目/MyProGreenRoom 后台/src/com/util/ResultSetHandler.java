package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ResultSetHandler {
	
	/**
	 * ���������
	 * @param rs
	 * @return
	 */
	public  ArrayList mapping(ResultSet rs) throws SQLException;
	

}
