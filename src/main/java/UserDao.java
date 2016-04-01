import java.sql.*;

/**
 * Created by yeonju on 2016-04-01.
 */
public class UserDao {
    public User get(Long id) throws SQLException, ClassNotFoundException {
        //DB��? Mysql
        //��ġ��?
        //table�� userinfo
        //Load Driver
        Class.forName("com.mysql.jdbc.Driver");
        //Connection �ΰ�
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/userinfo", "root", "1234");
        //���������
        String sql = "select * from userinfo where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        //����
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        //����� ������Ʈ�� �����ϰ�
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //�ڿ�����
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //���εȰ���� �����Ѵ�.
        return user;
    }
}
