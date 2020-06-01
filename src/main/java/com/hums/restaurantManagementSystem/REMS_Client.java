package com.hums.restaurantManagementSystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;

import com.hums.Client;

public class REMS_Client extends Client{

	@Override
	public void connect() {
		try {
			this.setConnection(new Socket(InetAddress.getLocalHost(), 5001));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Thread reader = new Thread() {
			public void run() {
				InputStream input;
				ObjectInputStream ois;		
				while(true) {
					try {
						input = getConnection().getInputStream();
						ois = new ObjectInputStream(input);
						//REMS_Registry response = (REMS_Registry) ois.readObject();
						//HERE WILL BE THE HRMS_GUI.setRegistry(response);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		reader.start();
	}

}
