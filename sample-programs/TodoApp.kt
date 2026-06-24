//AI added Task class(id, title, isCompleted)
data class Task(
    val id: Int,
    var title: String,
    var isCompleted: Boolean = false
)

fun main() {
    val tasks = mutableListOf<Task>()
    var nextId = 1

    while (true) {
        println("\n=== Todo List ===")
        println("1: Add task")
        println("2: View tasks")
        println("3: Complete/Uncomplete task") //new
        println("4: Delete task")
        println("5: Edit task") //new
        println("6: Exit")
        print("Choose (1-6): ")

        val choice = readLine() ?: continue

        when (choice) {
            "1" -> {
                print("Enter task: ")
                val taskTitle = readLine() ?: continue
                tasks.add(Task(nextId, taskTitle, false))
                nextId++
                println("Task added!")
            }
            "2" -> {
                if (tasks.isEmpty()) {
                    println("No tasks yet.")
                } else {
                    println("Your tasks:")
                    tasks.forEach { task ->
                        val status = if (task.isCompleted) "✓" else "✗" //add this tsk has completed  or not
                        println("${task.id}. [$status] ${task.title}")
                    }
                }
            }
            //AI add this part
            "3" -> {
                print("Enter task number to toggle: ")
                val numStr = readLine() ?: continue
                val num = numStr.toIntOrNull()
                val task = tasks.find { it.id == num }
                if (task != null) {
                    task.isCompleted = !task.isCompleted
                    val status = if (task.isCompleted) "completed" else "uncompleted"
                    println("Task marked as $status!")
                } else {
                    println("Task not found.")
                }
            }
            "4" -> {
                print("Enter task number to delete: ")
                val numStr = readLine() ?: continue
                val num = numStr.toIntOrNull()
                val task = tasks.find { it.id == num }
                if (task != null) {
                    tasks.remove(task)
                    println("Task deleted!")
                } else {
                    println("Task not found.")
                }
            }
            //AI add this edit part
            "5" -> {
                print("Enter task number to edit: ")
                val numStr = readLine() ?: continue
                val num = numStr.toIntOrNull()
                val task = tasks.find { it.id == num }
                if (task != null) {
                    print("Enter new task title: ")
                    val newTitle = readLine() ?: continue
                    task.title = newTitle
                    println("Task updated!")
                } else {
                    println("Task not found.")
                }
            }

            "6" -> {
                println("Goodbye!")
                break
            }
            else -> println("Invalid choice.")
        }
    }
}
