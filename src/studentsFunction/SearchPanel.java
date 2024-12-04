package studentsFunction;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class SearchPanel extends JPanel {
    public SearchPanel(JTable table, DefaultTableModel model, DataLoader dataLoader) {
        setLayout(new FlowLayout());

        JLabel searchLabel = new JLabel("Search By:");
        String[] searchCriteria = {"Name", "Major", "Age"};
        JComboBox<String> searchComboBox = new JComboBox<>(searchCriteria);
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Search");

        add(searchLabel);
        add(searchComboBox);
        add(searchField);
        add(searchButton);

        searchButton.addActionListener(e -> {
            String selectedCriteria = (String) searchComboBox.getSelectedItem();
            String searchText = searchField.getText();
            dataLoader.loadStudents(model, null, selectedCriteria, searchText);
        });
    }
}