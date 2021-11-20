package com.bridgelabz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressBookJDBC {

    private static Connection getConnection() {
        String url ="jdbc:mysql://localhost:3306/Address_Book?useSSL=false";
        String userName = "root";
        String password = "1234";
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }

    public static List<ContactInfo> retrieveData(String sql) {
        ResultSet resultSet = null;
        List<ContactInfo> contactInfoList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ContactInfo contactInfo = new ContactInfo();
                contactInfo.setFirst_name(resultSet.getString("first_name"));
                contactInfo.setLast_name(resultSet.getString("last_name"));
                contactInfo.setAddress(resultSet.getString("address"));
                contactInfo.setCity(resultSet.getString("city"));
                contactInfo.setState(resultSet.getString("state"));
                contactInfo.setZip(resultSet.getInt("zip"));
                contactInfo.setPhone_number(resultSet.getLong("phone_number"));
                contactInfo.setEmail(resultSet.getString("email"));

                contactInfoList.add(contactInfo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return contactInfoList;
    }

    public static void updateData(String first_name, String email, String sql) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, first_name);
            int result = preparedStatement.executeUpdate();
            if (result == 1) {
                System.out.println("query updated");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}