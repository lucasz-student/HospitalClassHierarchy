package com.solvd.laba;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

import com.solvd.laba.Utils.ConnectionPool;

public class ThreadingMain {
	
	public static void main(String[] args) {
		ConnectionPool pool = new ConnectionPool(5);
		
		pool.newRunnableTask(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Connection 1 Task 1 Finished");
		});
		
		pool.newRunnableTask(() -> {
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Connection 2 Task 1 Finished");
		});
		
		pool.newRunnableTask(() -> {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Connection 3 Task 1 Finished");
		});
		
		pool.newRunnableTask(() -> {
			try {
				Thread.sleep(12000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Connection 4 Task 1 Finished");
		});
		
		pool.newRunnableTask(() -> {
			try {
				Thread.sleep(14000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Connection 5 Task 1 Finished");
		});
		
		pool.newRunnableTask(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Connection 6 Task 1 Finished");
		});
		
		Supplier Task1 = () -> {
			return "Task 1";
		};
		Runnable Task2 = () -> {
			System.out.println("Task 2");
		};
		CompletableFuture f = pool.newTwoTasks(Task1, Task2);
		try {
			System.out.println(f.get());;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		Supplier SecondTask1 = () -> {
			return "Task 1";
		};
		
		Runnable SecondTask2 = () -> {
			System.out.println("Task 2");
		};
		
		CompletableFuture f2 = pool.newTwoTasks(SecondTask1, SecondTask2);
		try {
			System.out.println(f.get());;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
