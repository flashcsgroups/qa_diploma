package database;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
    public static String getLastStatusNotCredit() throws SQLException {
        try (Connection cn = ConnectionFactory.getConnection();
             Statement st = cn.createStatement()) {
            try (ResultSet rs = st.executeQuery("select status from payment_entity order by created;")) {
                ArrayList<String> codes = new ArrayList<>();
                while (rs.next()) {
                    codes.add(rs.getString("status"));
                }
                return codes.get(codes.size() - 1);
            }
        }
    }

    public static String getLastStatusCredit() throws SQLException {
        try (Connection cn = ConnectionFactory.getConnection();
             Statement st = cn.createStatement()) {
            try (ResultSet rs = st.executeQuery("select status from credit_request_entity order by created;")) {
                ArrayList<String> codes = new ArrayList<>();
                while (rs.next()) {
                    codes.add(rs.getString("status"));
                }
                return codes.get(codes.size() - 1);
            }
        }
    }
}