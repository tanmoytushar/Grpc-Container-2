package com.tanmoy.ContactFindService;

import com.tanmoy.ContactFindService.proto.Add.ApiResponse;
import com.tanmoy.ContactFindService.proto.ContactOuterClass.Contact;
import com.tanmoy.ContactFindService.proto.addGrpc;
import com.tanmoy.ContactFindService.proto.addGrpc.addBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ContactAddClient {
	
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		// stubs - generate from proto
		addBlockingStub blockingStub = addGrpc.newBlockingStub(channel);

		Contact contact = Contact.newBuilder().setFirstName("Tonu").setLastName("Ton").setEmail("tonu.ton@gmail.com").build();
		ApiResponse apiResponse = blockingStub.addContact(contact);
		System.out.println(apiResponse.getResponseMessage());
		System.out.println(apiResponse.getContact().toString());
		
	}

}
