fun main() {
    val tasks = mutableListOf<String>()

    while (true) {
        println("\n=== Todo List ===")
        println("1: Add task")
        println("2: View tasks")
        println("3: Delete task")
        println("4: Exit")
        print("Choose (1-4): ")

        val choice = readLine() ?: continue
        
        when (choice) {
            "1" -> {
                print("Enter task: ")
                val task = readLine() ?: continue
                tasks.add(task)
                println("Task added!")
            }
            "2" -> {
