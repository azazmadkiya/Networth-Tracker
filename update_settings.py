with open('app/src/main/java/com/example/ui/screens/SettingsScreen.kt', 'r') as f:
    content = f.read()

target = """                SettingsRow(
                    icon = Icons.Default.Person,
                    title = "User ID",
                    subtitle = viewModel.authManager.getStoredUserId().ifEmpty { "Not Set" },
                    onClick = {}
                )"""

content = content.replace(target, "")

with open('app/src/main/java/com/example/ui/screens/SettingsScreen.kt', 'w') as f:
    f.write(content)
