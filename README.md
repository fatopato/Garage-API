# Garage API

### Basic Garage Application for Parking Management

The API consists of two different REST Controller 

* SlotController
  * You can see the status of the all slots, get free slots and get available slots according to slot size of the vehicles.
* GarageController
    * You can park and leave the car. Additionally, you can see the current status of the garage

The application runs on 8080 port as default.

For parking and leaving the garage VehicleDto must be sent on request body.
Request dto examples:
* for car:
  * {
    "plate": "34ca2",
    "color": "green",
    "vehicleType": "CAR"
    }
* for jeep:
  * {
    "plate": "34ca12",
    "color": "blue",
    "vehicleType": "JEEP"
    }
* for truck:
  * {
    "plate": "34yz21",
    "color": "red",
    "vehicleType": "TRUCK"
    }

The status info shows the vehicles on the garage and the occupied slots.

Sample requests can be seen on the POSTMAN Collection:
https://www.getpostman.com/collections/5fb78cce091d6c292649


