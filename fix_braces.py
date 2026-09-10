with open('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt', 'r') as f:
    content = f.read()

# Removing one extra closing brace before // Actions
content = content.replace("                        }\n                    }\n                }\n                \n                // Actions", "                        }\n                    }\n                \n                // Actions")

with open('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt', 'w') as f:
    f.write(content)
    
with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'r') as f:
    content = f.read()

content = content.replace("                        }\n                    }\n                }\n\n                Spacer(modifier = Modifier.height(24.dp))", "                        }\n                    }\n\n                Spacer(modifier = Modifier.height(24.dp))")

with open('app/src/main/java/com/example/ui/components/AddLedgerEntryDialog.kt', 'w') as f:
    f.write(content)
