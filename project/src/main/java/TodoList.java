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
        String space = "                                  ";
        //return String.format("%-30s | %s", this.description);
        return (this.description + space).substring(0, 34) + "| " + this.status;
    }
}

public class TodoList {
    private Task[] tasks;
    private int capacity;
    private int count;

    public TodoList(int capacity){
        this.capacity = 3;
        this.count = 0 ;
        this.tasks = new Task[capacity];
    };

    public void addTask(String description) {
        if (this.count < this.capacity) {
            this.tasks[this.count] = new Task(description);
            this.count++;
        }
    }

    public void setStatus(int index, TaskStatus status){
        if (index >= 0 && index < this.count) {
            this.tasks[index].setStatus(status);
        }
    };

    public void setDescription(int index, String newDescription){
        if (index <= this.count - 1) {
            this.tasks[index].setDescription(newDescription);
        }
    };

    public void displayTasks(){
        System.out.println("Tasks:");
        for (int i = 0 ; i < this.count ; i ++ ){
            System.out.println(tasks[i].toString());
        }
    };
}
