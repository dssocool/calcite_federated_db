package org.feddb.core;

import java.sql.*;
import java.util.Properties;

public class FedDBSession {
    private final Connection connection;

    private FedDBSession(Properties info) throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:calcite:", info);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Properties info;

        private Builder() {
            info = new Properties();
        }

        public Builder config(String config, String value) {
            info.put(config, value);
            return this;
        }

        public FedDBSession build() {
            try {
                return new FedDBSession(info);
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ResultSet sql(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
        return statement.getResultSet();
    }
}