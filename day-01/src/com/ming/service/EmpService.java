package com.ming.service;

import com.ming.dao.EmpDao;

import java.sql.SQLException;

public class EmpService {
    public int update(String empId, String empName) throws SQLException {
        EmpDao dao = new EmpDao();
        // 进行更新
        return dao.update(empId, empName);
    }
}
