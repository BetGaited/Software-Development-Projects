import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Expense {

    private final SimpleDoubleProperty amount;
    private final SimpleStringProperty category;
    private final SimpleStringProperty date;
    private final SimpleStringProperty description;

    public Expense(double amount, String category, String date, String description) {
        this.amount = new SimpleDoubleProperty(amount);
        this.category = new SimpleStringProperty(category);
        this.date = new SimpleStringProperty(date);
        this.description = new SimpleStringProperty(description);
    }

    public double GetAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty AmountProperty() {
        return amount;
    }

    public String GetCategory() {
        return category.get();
    }

    public SimpleStringProperty CategoryProperty() {
        return category;
    }

    public String GetDate() {
        return date.get();
    }

    public SimpleStringProperty DateProperty() {
        return date;
    }

    public String GetDescription() {
        return description.get();
    }

    public SimpleStringProperty DescriptionProperty() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Amount: %.2f, Category: %s, Date: %s, Description: %s",
                GetAmount(), GetCategory(), GetDate(), GetDescription());
    }
}