def count_braces(file_path):
    with open(file_path, 'r') as f:
        content = f.read()
    
    level = 0
    for idx, c in enumerate(content):
        if c == '{':
            level += 1
        elif c == '}':
            level -= 1
            if level < 0:
                print(f"Negative level at index {idx} in {file_path}")
    print(f"Final level for {file_path}: {level}")

count_braces('app/src/main/java/com/example/ui/components/AddEditItemDialog.kt')
