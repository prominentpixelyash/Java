package com.prominentpixel.models;

public class HR extends Employee2{

    private String hrContactNumber;
    private String hrEmailId;

    public HR() {
    }

    public HR(int id, String name, String department, Address address,EmpType type, String hrContactNumber, String hrEmailId) {
        super(id, name, department, null,type);
        this.hrContactNumber = hrContactNumber;
        this.hrEmailId = hrEmailId;
    }

    public String getHrContactNumber() {
        return hrContactNumber;
    }

    public void setHrContactNumber(String hrContactNumber) {
        this.hrContactNumber = hrContactNumber;
    }

    public String getHrEmailId() {
        return hrEmailId;
    }

    public void setHrEmailId(String hrEmailId) {
        this.hrEmailId = hrEmailId;
    }

    @Override
    public String toString() {
        return "HR{" +
                "hrContactNumber='" + hrContactNumber + '\'' +
                ", hrEmailId='" + hrEmailId + '\'' +
                '}';
    }
}
