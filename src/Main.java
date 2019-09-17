import java.sql.*;

public class Main {

    private static Connection mysqlConnection;

    public static void openConnection() throws SQLException {
        try {
            mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codegym", "root", "123456");
        } catch (SQLException e) {
            System.out.println("Có lỗi khi kết nối cơ sở dữ liệu");
            System.out.println(e.getMessage());
        }
    }

    public static void closeConnection() throws SQLException {
        if (mysqlConnection != null && !mysqlConnection.isClosed()) {
            mysqlConnection.close();
        }
    }

    public static Statement createStatement() throws SQLException {

        if (mysqlConnection == null) {
            openConnection();
        }

        Statement statement= mysqlConnection.createStatement();
        return statement;
    }

    public static PreparedStatement createPrepareStatement(String sql) throws SQLException {

        if (mysqlConnection == null) {
            openConnection();
        }

        PreparedStatement statement= mysqlConnection.prepareStatement(sql);
        return statement;
    }

    public static void main(String[] args) {
        try {
            openConnection();

            // Đọc dữ liệu
            Statement statement = createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Giang_Vien");
            while(result.next()){
                System.out.println(result.getString(1)+"\t"+result.getString(2));
            }


            // Thêm dữ liệu
//            String sql = "INSERT INTO Giang_Vien (id, fullname) VALUES (?, ?)";
//
//            PreparedStatement statement = createPrepareStatement(sql);
//            statement.setInt(1, 4);
//            statement.setString(2, "Bill Gates");
//
//            int rowsInserted = statement.executeUpdate();
//            if (rowsInserted > 0) {
//                System.out.println("Giảng viên mới đã được thêm thành công");
//            }

            // Cập nhật dữ liệu
//            String sql = "UPDATE Giang_Vien SET fullname=? WHERE id=?";
//
//            PreparedStatement statement = createPrepareStatement(sql);
//            statement.setString(1, "Gates");
//            statement.setInt(2, 4);
//
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("Giảng viên đã được cập nhật thành công!");
//            }

            // Xóa giảng viên
//            String sql = "DELETE FROM Giang_Vien WHERE id=?";
//
//            PreparedStatement statement = createPrepareStatement(sql);
//            statement.setInt(1, 4);
//
//            int rowsDeleted = statement.executeUpdate();
//            if (rowsDeleted > 0) {
//                System.out.println("Giảng viên mới đã được xóa thành công!");
//            }

            closeConnection();
        } catch (SQLException e) {
            System.out.println("Lỗi");
            System.out.println(e.getMessage());
        } finally {
        }
    }
}

