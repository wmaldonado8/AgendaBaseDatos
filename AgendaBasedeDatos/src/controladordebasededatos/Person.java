/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladordebasededatos;

/**
 *
 * @author PCD
 */
public class Person {
    private int address_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_Number;

    public Person() {
    }

    public Person(int address_id, String first_name, String last_name, String email, String phone_Number) {
        this.address_id = address_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_Number = phone_Number;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    @Override
    public String toString() {
        return "Persona{" + "address_id=" + address_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phone_Number=" + phone_Number + '}';
    }
    
    
}
