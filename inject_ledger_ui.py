import sys

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'r') as f:
    content = f.read()

with open('ui_injection_ledger.txt', 'r') as f:
    ui_str = f.read()

target = """                OutlinedTextField(
                    value = notes,"""

new_content = content.replace(target, ui_str + target)

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'w') as f:
    f.write(new_content)
