with open('app/src/main/java/com/example/ui/components/AppDrawer.kt', 'r') as f:
    content = f.read()
    
new_imports = """
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.SyncAlt
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
"""

content = content.replace('import androidx.compose.material3.*', 'import androidx.compose.material3.*\n' + new_imports)

with open('app/src/main/java/com/example/ui/components/AppDrawer.kt', 'w') as f:
    f.write(content)
