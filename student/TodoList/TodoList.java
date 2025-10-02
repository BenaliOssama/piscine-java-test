enum TaskStatus {
    NEW, IN_PROGRESS, COMPLETED
}

class Task {
    private String description;
    private TaskStatus status;

    public Task(String n) {
        // enforce max 30 characters
        if (n.length() > 30) {
            this.description = n.substring(0, 30);
        } else {
            this.description = n;
        }
        this.status = TaskStatus.NEW;
    }


    public String getDescription(){
        return this.description;
    }

    public void setDescription(String d) {
        this.description = d;
    }

    public TaskStatus getStatus(){
        return this.status;
    }

    public void setStatus(TaskStatus d) {
        this.status = d;
    }

    @Override 
    public String toString() {
        return String.format("%-30s | %s", description, status);
    }
}

public class TodoList {
    private Task[] tasks;
    private int capacity;
    private int len;

    public TodoList(int capacity){
        this.capacity = 3;
        this.len = 0 ;
        this.tasks = new Task[capacity];
    };

    public void addTask(String description) {
        if (this.len < this.capacity) {
            this.tasks[this.len] = new Task(description);
            this.len++;
        }
    }

    public void setStatus(int index, TaskStatus status){
        if (index >= 0 && index < this.len) {
            this.tasks[index].setStatus(status);
        }
    };

    public void setDescription(int index, String newDescription){
        if (index <= this.len - 1) {
            this.tasks[index].setDescription(newDescription);
        }
    };

    public void displayTasks(){
        for (int i = 0 ; i < this.len ; i ++ ){
            System.out.println(tasks[i]);
        }
    };
}
