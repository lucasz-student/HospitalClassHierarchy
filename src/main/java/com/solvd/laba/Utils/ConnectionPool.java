package com.solvd.laba.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class ConnectionPool {

	private ArrayBlockingQueue<Connection> Pool;
	private int size;
	
	
	public ConnectionPool(int size) {
		this.Pool = new ArrayBlockingQueue<Connection>(size);
		this.size = size;
	}	
	
	private Connection fetchOrStartConnection() {
		boolean found = false;
		if (this.Pool.size() == this.size) {
			Utils.logger.info("Connections are full");
			Utils.logger.info("Waiting For Idle Connections");
			while (!found) {
				for (Connection c: this.Pool) {
					if (c.status == ConnectionStatus.IDLE) {
						Utils.logger.info("Connection found");
						return c;
					}
				}
			}
		} 
		Connection connection = new Connection();
		this.Pool.add(connection);
		return connection;

	}
	
	public Future newRunnableTask(Runnable runnable) {
		Connection connection = this.fetchOrStartConnection();
		connection.status = ConnectionStatus.ACTIVE;
		Future f = connection.StartVoidThread(runnable);
		this.returnConnection(connection, f);
		return f;
	}
	
	public CompletableFuture newTwoTasks(Supplier firstTask, Runnable secondTask) {
		Connection connection = this.fetchOrStartConnection();
		connection.status = ConnectionStatus.ACTIVE;
		CompletableFuture f = connection.StartReturnableThread(firstTask, secondTask);
		this.returnConnection(connection, f);
		return f;
	}
	
	public CompletableFuture newTwoTasks(Supplier firstTask, Consumer secondTask) {
		Connection connection = this.fetchOrStartConnection();
		connection.status = ConnectionStatus.ACTIVE;
		CompletableFuture f = connection.StartReturnableThread(firstTask, secondTask);
		this.returnConnection(connection, f);
		return f;
	}

	private void returnConnection(Connection c, Future f) {
		Thread t = new Thread(() -> {
			while (!f.isDone()) {
			}
			c.status = ConnectionStatus.IDLE;
		});
		t.start();
	}
	
	private void returnConnection(Connection c, CompletableFuture f) {
		Thread t = new Thread(() -> {
			while (!f.isDone()) {
			}
			c.status = ConnectionStatus.IDLE;
		});
		t.start();
	}
	
	private static class Connection {
		ExecutorService s = Executors.newSingleThreadExecutor();
		ConnectionStatus status;
		
		Connection() {
			this.status = ConnectionStatus.IDLE;
		}
		
		Future StartVoidThread(Runnable runnable) {
			Future f = s.submit(runnable);
			return f;
		}
		
		CompletableFuture StartReturnableThread(Supplier fTask, Runnable sTask) {
			CompletableFuture cf = CompletableFuture.supplyAsync(fTask, s);
			cf.thenRun(sTask);
			return cf;
		}
		
		CompletableFuture StartReturnableThread(Supplier fTask, Consumer sTask) {
			CompletableFuture cf = CompletableFuture.supplyAsync(fTask, s);
			cf.thenAccept(sTask);
			return cf;
		}
	}
}
