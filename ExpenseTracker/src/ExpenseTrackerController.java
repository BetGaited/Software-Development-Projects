import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseTrackerController {

    @FXML
    private TextField AmountTable;

    @FXML
    private ComboBox<String> CategoryDropdown;

    @FXML
    private DatePicker DateTable;

    @FXML
    private TextField DescriptionTable;

    @FXML
    private TableView<Expense> ExpenseTable;

    @FXML
    private TableColumn<Expense, Double> AmountColumn;

    @FXML
    private TableColumn<Expense, String> CategoryColumn;

    @FXML
    private TableColumn<Expense, String> DateColumn;

    @FXML
    private TableColumn<Expense, String> DescriptionColumn;

    private List<Expense> Expenses = new ArrayList<>();

    public void initialize() {
        CategoryDropdown.getItems().addAll("Food", "Transportation", "Utilities", "Entertainment", "Clothing", "Insurance", "Housing", "Other");

        AmountColumn.setCellValueFactory(cellData -> cellData.getValue().AmountProperty().asObject());
        CategoryColumn.setCellValueFactory(cellData -> cellData.getValue().CategoryProperty());
        DateColumn.setCellValueFactory(cellData -> cellData.getValue().DateProperty());
        DescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().DescriptionProperty());

        ExpenseTable.getItems().addAll(Expenses);
    }

    @FXML
    private void AddExpense() {
        try {
            double amount = Double.parseDouble(AmountTable.getText());
            String category = CategoryDropdown.getValue();
            String date = DateTable.getValue().toString();
            String description = DescriptionTable.getText();

            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be greater than 0.");
            }

            Expense expense = new Expense(amount, category, date, description);
            Expenses.add(expense);
            ExpenseTable.getItems().add(expense);

            AmountTable.clear();
            CategoryDropdown.getSelectionModel().clearSelection();
            DateTable.getEditor().clear();
            DescriptionTable.clear();
        } 
        
        catch (NumberFormatException e) {
            ShowAlert("Invalid amount. Please enter a valid number.");
        } 
        
        catch (NullPointerException e) {
            ShowAlert("Fill in all fields.");
        } 
        
        catch (IllegalArgumentException e) {
            ShowAlert(e.getMessage());
        }
    }

    @FXML
    private void DeleteExpense() {
        int SelectedIndex = ExpenseTable.getSelectionModel().getSelectedIndex();
        if (SelectedIndex >= 0) {
            ExpenseTable.getItems().remove(SelectedIndex);
            Expenses.remove(SelectedIndex);
        } 
        
        else {
            ShowAlert("Nothing selected for deletion.");
        }
    }

    @FXML
    private void SaveExpensesToFile() {
        try {
            File file = new File("expenses.txt");
            FileWriter writer = new FileWriter(file);
            for (Expense expense : Expenses) {
                writer.write(expense.toString() + "\n");
            }
            writer.close();
        } 
        
        catch (IOException e) {
            ShowAlert("Error saving expenses to file.");
        }
    }

    private void ShowAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
