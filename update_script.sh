sed -i 's/onSave: (FinancialItem) -> Unit/onSave: (FinancialItem, com.example.data.model.LedgerEntry?, FinancialItem?) -> Unit/g' app/src/main/java/com/example/ui/components/AddEditItemDialog.kt
