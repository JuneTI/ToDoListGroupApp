package java_todo;
import java.util.*;

//Rough draft/outline of the list class. I used Lance's Task class outline for the Task methods since I haven't implemented them. I figure we can add more methods
//and other changes as we improve on it and especially when we get to GUI and events in class. I picked an ArrayList for the container since it works like a vector in C++
//and holds objects (which could be Task objects for us). We can definitely change it to a different container if there is one that anyone thinks works better
//for our project.
public class toDo {
	
	private ArrayList<Task> tasks;
	
	public toDo(){
		tasks = new ArrayList<Task>();
		Task demoTask = new Task(/*Task constructor args go here*/);
		tasks.addTask(demoTask);
	}
	
	public void addTask(Task t) {
		boolean duplicate = false;
		for (Task ele : tasks) {
			if (ele.equals(t)) {
				duplicate = true;
			}
		}
		if(!duplicate) {
			tasks.add(t);
		}
	}
	
	public void completeTask(Task t) {
		for (Task ele : tasks) {
			if(ele.equals(t)) { //For this to work, we should override the "public boolean equals(Task tk)" method of the Task class so that it checks for 
								//matching private data vars
				ele.setStatus(false);
			}
		}
	}
	
	public void removeTask(Task t) {
		for (Task ele : tasks) {
			if(ele.equals(t)) {
				tasks.remove(ele);
			}
		}
	}
	
	public void editTask(Task t, String id, boolean status, String projName, String dueDate, int day, int month, int year) {
		for (Task ele : tasks) {
			if(ele.equals(t)) {
				ele.setId(id);
				ele.setStatus(status);
				ele.setProjectName(projName);
				ele.setDueDate(dueDate);
				ele.setDay(day);
				ele.setMonth(month);
				ele.setYear(year);
			}
		}
	}
	
	public void printTasks() {
		for (Task t : tasks) {
			System.out.println(t); //Need to override toString of the Task class to print the title of the task
		}
	}
	
	public void sortByDueDate() {
	}
	
	public void sortByTitle() {
	}
	
	public void sortByStatus() {
	}
	
	public void sortByCategory(){
	}
	
	public void sortByPriority(){
	}
	
	@Override
	public String toString() {
		for(Task t : tasks) {
			System.out.printf("%s%s - %s", t.getStatus() ? "Checked " : "", t.getTitle(), t.getdueDate()); //Prints that the task is checked off if 
																										//the task's status is true, otherwise prints nothing
		}
	} 
}
