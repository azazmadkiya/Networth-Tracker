import re

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'r') as f:
    content = f.read()

# Add imports
imports = """import androidx.compose.material3.TextButton
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Switch
import com.example.data.model.FinancialItem"""
content = content.replace("import androidx.compose.material3.TextButton", imports)

# Add OptIn and modify signature
old_sig = """@Composable
fun AddLedgerEntryDialog(
    onDismiss: () -> Unit,
    onSave: (LedgerEntry) -> Unit,
    onSaveAndShare: ((LedgerEntry) -> Unit)? = null
) {"""

new_sig = """@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun AddLedgerEntryDialog(
    parties: List<FinancialItem> = emptyList(),
    onDismiss: () -> Unit,
    onSave: (LedgerEntry, FinancialItem?) -> Unit,
    onSaveAndShare: ((LedgerEntry, FinancialItem?) -> Unit)? = null
) {"""
content = content.replace(old_sig, new_sig)

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'w') as f:
    f.write(content)
