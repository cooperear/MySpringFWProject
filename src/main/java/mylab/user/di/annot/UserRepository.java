package mylab.user.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Value("${userDiAnnotSqlRepo}")
    private String dbType;

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public boolean saveUser(String userId, String name) {
        System.out.println("사용자 저장: " + userId + ", " + name + " (DB: " + dbType + ")");
        return true;
    }

    @Override
    public String toString() {
        return "UserRepository [dbType=" + dbType + "]";
    }
}