package application;
import java.util.*;

public class toDo {
	
	private ArrayList<Task> tasks; //Storage container for Task objects
	
	//Constructor
	public toDo(){
		tasks = new ArrayList<Task>();
		Task demoTask = new Task("Java Homework");
		addTask(demoTask);
	}
	
	//toDo methods
	public Task getTask(int index) {
		return tasks.get(index);
	}
	public void addTask(Task t) {
		int index = 0;
		boolean duplicate = false;
		while(!duplicate && index<tasks.size()) {
			if (tasks.get(index).equals(t)) {
				duplicate = true;
			}
			index++;
		}
		if(!duplicate) {
			tasks.add(t);
		}
	}
	public void completeTask(Task t) {
		int index = 0;
		boolean found = false;
		Task toComplete;
		while(!found && index<tasks.size()) {
			toComplete = tasks.get(index);
			if (toComplete.equals(t)) {
				found = true;
				toComplete.setStatus(true);
			} else {
				index++;
			}
		}
	}
	public void removeTask(Task t) {
		int index = 0;
		boolean found = false;
		Task toRemove;
		while(!found && index<tasks.size()) {
			toRemove = tasks.get(index);
			if (toRemove.equals(t)) {
				found = true;
				tasks.remove(index);
			} else {
				index++;
			}
		}
	}
	public void editTask(Task t, String title, boolean status, Date dueDate, String category, int priority) {
		int index = 0;
		boolean found = false;
		Task toEdit;
		while(!found && index<tasks.size()) {
			toEdit = tasks.get(index);
			if (toEdit.equals(t)) {
				found = true;
				toEdit.setTitle(title);
				toEdit.setStatus(status);
				toEdit.setDueDate(dueDate);
				toEdit.setCategory(category);
				toEdit.setPriority(priority);
			} else {
				index++;
			}
		}
	}
	public void printTasks() {
		for (Task t : tasks) {
			System.out.println(t);
		}
	}
	public int getNumOfTasks() {
		return tasks.size();
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
}