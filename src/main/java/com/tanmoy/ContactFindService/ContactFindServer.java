package com.tanmoy.ContactFindService;

import java.io.IOException;

import com.tanmoy.ContactFindService.service.ContactFindService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ContactFindServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Grpc contact find server started");
		Server server = ServerBuilder.forPort(9090).addService(new ContactFindService()).build();
		server.start();
		System.out.println("Grpc contact find server started at port: " + server.getPort());
		server.awaitTermination();
	}

}
