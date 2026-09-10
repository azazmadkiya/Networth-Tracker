import sys

with open('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt', 'r') as f:
    content = f.read()

with open('ui_injection.txt', 'r') as f:
    ui_str = f.read()

new_content = content.replace('                // Actions', ui_str + '\n                // Actions')

with open('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt', 'w') as f:
    f.write(new_content)
