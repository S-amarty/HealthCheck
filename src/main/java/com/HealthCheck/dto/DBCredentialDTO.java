package com.HealthCheck.dto;

public class DBCredentialDTO {

    private String hostname;
    private int port;
    private String servicename;
    private String username;
    private String password;

    // Constructors, getters, and setters...

    public DBCredentialDTO(String hostname, int port, String servicename, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.servicename = servicename;
        this.username = username;
        this.password = password;
    }

    // Getters and setters...

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getservicename() {
        return servicename;
    }

    public void setservicename(String servicename) {
        this.servicename = servicename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
