package com.prominentpixel.models;

public class Manager extends Employee2{

    private String responsibility;

    public Manager(){

    }

    public Manager(int id,String name,String department,Address address,EmpType type,String responsibility){
        super(id,name,department,null,type);
        this.responsibility=responsibility;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "responsibility='" + responsibility + '\'' +
                '}';
    }
}
