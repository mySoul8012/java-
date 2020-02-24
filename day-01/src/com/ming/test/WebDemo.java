package com.ming.test;

import com.ming.service.EmpService;

import java.sql.SQLException;
import java.util.Scanner;

public class WebDemo {
    public static void main(String[] args) throws SQLException {
        // 定义控制台接收对象
        Scanner scanner =  new Scanner(System.in);
        // 进行打印
        System.out.println("进入员工姓名修改程序");
        System.out.println("输入修改员工编号");
        // 创建Service对象
        EmpService service = new EmpService();
        String empId = scanner.nextLine();
        String empName = scanner.nextLine();
        // 调用service保存方法
        int count = service.update(empId, empName);
        // 进行判断
        if(count >= 1){
            System.out.println("更新成功");
        }else{
            System.out.println("更新失败");
        }
    }
}
