package com.tanmoy.ContactFindService.service;

import com.tanmoy.ContactFindService.proto.ContactOuterClass.Contact;
import com.tanmoy.ContactFindService.proto.Find.ApiResponse;
import com.tanmoy.ContactFindService.proto.Find.FindRequest;
import com.tanmoy.ContactFindService.proto.findGrpc.findImplBase;
import com.tanmoy.ContactFindService.repo.ContactRepository;

import io.grpc.stub.StreamObserver;

public class ContactFindService extends findImplBase {
	
	@Override
	public void findContact(FindRequest request, StreamObserver<ApiResponse> responseObserver) {
		
		ApiResponse.Builder response = ApiResponse.newBuilder();
		ContactRepository repo = new ContactRepository();
		
		int requestId = request.getId();
		
		Contact contact = repo.findContact(requestId);

		if(contact != null) {
			response.setResponseCode(1).setResponseMessage("Success").setContact(contact);
		} else {
			response.setResponseCode(0).setResponseMessage("Failed");
		}
		// setting response value to response observer
		responseObserver.onNext(response.build());
		// closing response observer
		responseObserver.onCompleted();
		
	}

}
