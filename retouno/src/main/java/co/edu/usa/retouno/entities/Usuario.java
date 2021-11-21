package co.edu.usa.retouno.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name="user_email", nullable = false, length=50)
    private String email;
    @NonNull
    @Column(name="user_name", nullable = false, length=80)
    private String name;
    @NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;

    public Usuario(String email2, String password2, String string) {
    }
    public Usuario(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }


    
    
}
    

