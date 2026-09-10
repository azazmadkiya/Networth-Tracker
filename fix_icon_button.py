with open('app/src/main/java/com/example/MainActivity.kt', 'r') as f:
    content = f.read()

content = content.replace('import androidx.compose.material3.TopAppBarDefaults', 'import androidx.compose.material3.TopAppBarDefaults\nimport androidx.compose.material3.IconButton')

with open('app/src/main/java/com/example/MainActivity.kt', 'w') as f:
    f.write(content)
