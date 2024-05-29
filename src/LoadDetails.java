import java.sql.*;

public class LoadDetails {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    void connectToDatabase() {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbFilePath = "jdbc:sqlite:cropdb.db"; // Update this with your database file path
            connection = DriverManager.getConnection(dbFilePath);
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
//
    void populateCropBox() {
        Page2.cropComboBox.removeAllItems();
        try {
            String query = "SELECT DISTINCT cropName FROM cropDetails"; // Replace with your table name
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String cropName = resultSet.getString("cropName");
                //System.out.println("District Name: " + districtName);
                Page2.cropComboBox.addItem(cropName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void populateVarietyBox(String selectedCrop) {
        Page2.varietyComboBox.removeAllItems();
        try {
            String query = "SELECT variety FROM cropDetails WHERE cropName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, selectedCrop);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Page2.varietyComboBox.addItem(resultSet.getString("variety"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Page2.varietyComboBox.setSelectedItem(null);
    }


    void populateDistrictBox() {
        Page2.districtComboBox.removeAllItems();
        try {
            String query = "SELECT DISTINCT District_name FROM blockstable"; // Replace with your table name
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String districtName = resultSet.getString("District_name");
                //System.out.println("District Name: " + districtName);
                Page2.districtComboBox.addItem(districtName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void populateBlockBox(String selectedDistrict) {
        // Clear the combobox items
        Page2.blockComboBox.removeAllItems();

        // Database query to get block names for the selected district
        String query = "SELECT Block_name FROM blockstable WHERE District_name = ?";

        // Use try-with-resources to ensure resources are closed properly
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the parameter for the district name
            preparedStatement.setString(1, selectedDistrict);

            // Execute the query and get the result set
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Iterate through the result set and add block names to the combobox
                while (resultSet.next()) {
                    String blockName = resultSet.getString("Block_name");
                    Page2.blockComboBox.addItem(blockName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set the selected item to null to ensure no item is pre-selected
        Page2.blockComboBox.setSelectedItem(null);
    }

    void populateMouzaBox(String selectedBlock) {
        // Clear the combobox items
        Page2.mouzaComboBox.removeAllItems();
        String query = "SELECT Mouza_name FROM mouzaDetails WHERE Block_name = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // Set the parameter for the block name
            preparedStatement.setString(1, selectedBlock);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String mouzaName = resultSet.getString("Mouza_name");
                    Page2.mouzaComboBox.addItem(mouzaName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Page2.mouzaComboBox.setSelectedItem(null);
    }

}
