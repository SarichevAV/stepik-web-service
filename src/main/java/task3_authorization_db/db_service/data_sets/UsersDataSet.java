package task3_authorization_db.db_service.data_sets;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class UsersDataSet {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id", unique = true)
    private long id;
    @Column (name = "LOGIN")
    private String login;
    @Column (name = "PASSWORD")
    private String password;

    public UsersDataSet(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UsersDataSet() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersDataSet that = (UsersDataSet) o;
        return id == that.id &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password);
    }
}
