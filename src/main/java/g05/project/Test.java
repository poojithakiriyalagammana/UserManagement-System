/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g05.project;

import java.util.ArrayList;

/**
 *
 * @author CHAMMA
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.deleteEmployee();
    }
    
    public void insertEmployee() {
        String query = "INSERT INTO `employee`(`fname`, `lname`, `mobile`) VALUES(?, ?, ?)";
        ArrayList list = new ArrayList();
        list.add("Nimal");
        list.add("Bandara");
        list.add("0779474416");
        Myconnection.iudSafe(query, list);
    }
    
    public void deleteEmployee() {
        String query = "UPDATE `employee_list` SET `remove`=0 WHERE `srno`=4";
        Myconnection.iud(query);
    }
}
