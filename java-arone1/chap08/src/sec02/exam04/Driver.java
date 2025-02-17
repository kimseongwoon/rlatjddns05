package sec02.exam04;

import sec02.exam02.Bus;

import sec02.exam02.Vehicle;

public class Driver {
	public void drive(Vehicle vehicle) {
	  if(vehicle instanceof Bus) {
		 Bus bus = (Bus) vehicle; 
	   }
	   vehicle.run(); 
	}
}
