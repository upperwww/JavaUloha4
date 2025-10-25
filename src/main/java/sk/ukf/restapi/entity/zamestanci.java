package sk.ukf.restapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "employee")
public class zamestanci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Meno je povinné")
    @Size(min = 2, max = 50, message = "Meno musí mať 2-50 znakov")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Priezvisko je povinné")
    @Size(min = 2, max = 50, message = "Priezvisko musí mať 2-50 znakov")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private Date birth_date;

    @NotBlank(message = "Email je povinný")
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]{1,64}@[a-zA-Z0-9.-]{1,253}\\.[a-zA-Z]{2,6}$",
            message = "Neplatný email"
    )
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "job_title")
    private String job_title;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "full_time")
    private boolean full_time;

    public zamestanci() {
    }

    public zamestanci(int id, String firstName, String lastName, Date birth_date, String email, String phone, String job_title, Float salary, boolean full_time) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth_date = birth_date;
        this.email = email;
        this.phone = phone;
        this.job_title = job_title;
        this.salary = salary;
        this.full_time = full_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public boolean isFull_time() {
        return full_time;
    }

    public void setFull_time(boolean full_time) {
        this.full_time = full_time;
    }
}
