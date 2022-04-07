# Task
MySQL

Username : root
Password: 12345

irrigationdb tables
-------------------

CREATE TABLE irrigationdb. `SENSORS` (
  `DEVICE_NAME` varchar(100) NOT NULL,
  `TIME_SLOT` int(100) NOT NULL,
  `WATER_LEVEL` int(100) NOT NULL,
  `STATUS` varchar(100) NOT NULL,
  PRIMARY KEY (`DEVICE_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

SAMPLE DATA :

DEVICE_NAME  TIME_SLOT     WATER_LEVEL    STATUS
SENSOR1	    10	           90000	 AVAILABLE
SENSOR2	    5	           30000	 AVAILABLE
SENSOR3	    7	           5000	         AVAILABLE

....................................................

CREATE TABLE irrigationdb. `PLOTS` (
  `PLOT_NAME` varchar(100) NOT NULL,
  `TIME_SLOT` int(100) NOT NULL,
  `WATER_LEVEL` int(100) NOT NULL,
  `STATUS` varchar(100) NOT NULL,
  PRIMARY KEY (`DEVICE_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


SAMPLE DATA :
PLOT_NAME  TIME_SLOT     WATER_AMOUNT    STATUS
Apple	    10	          90000	        NOT IRRIGATED
GRAPES	    5	          30000	        NOT IRRIGATED
MANGO	    7	           5000	        NOT IRRIGATED

........................................................

Requiment:

Eclipse
Java8
MySQL
Postman(to call APIS)
......................................................



APIS:

1.  To get all the plots 

GET                      http://localhost:8080/getAllPlots    


Response

[
    {
        "plotName": "Apple",
        "timeSlot": 10,
        "waterAmount": 90000,
        "status": "IRRIGATED"
    },
    {
        "plotName": "GRAPES",
        "timeSlot": 5,
        "waterAmount": 30000,
        "status": "IRRIGATED"
    },
    {
        "plotName": "MANGO",
        "timeSlot": 7,
        "waterAmount": 5000,
        "status": "NOT IRRIGATED"
    }
]


2. To edit a plot by name and changing time slot for that plot and return the plot which got edited 

GET                   http://localhost:8080/editPlotByName?name=Apple&time=11

Response

{
    "plotName": "Apple",
    "timeSlot": 11,
    "waterAmount": 90000,
    "status": "IRRIGATED"
}

timeslot got edited to 11 , it was 10 before calling this API


3. To add a plot , after adding it will return the details of the plot which got inserted into DB


POST                            http://localhost:8080/addPlot

Input JSON , plot details to store into DB

 {
        "plotName": "Orange",
        "timeSlot": 9,
        "waterAmount": 90000,
        "status": "NOT IRRIGATED"
  }

Response


{
    "plotName": "Orange",
    "timeSlot": 9,
    "waterAmount": 90000,
    "status": "NOT IRRIGATED"
}


4. To irrigate a plot by sending the sensor name and to get the plot which got irrigated by this sensor device based on water amount and time slot


GET                           http://localhost:8080/irrigatePlot?sensorName=SENSOR2

Response

{
    "statusmessage": "successfully irriragated",
    "plot": {
        "plotName": "GRAPES",
        "timeSlot": 5,
        "waterAmount": 30000,
        "status": "IRRIGATED"
    }
}

Status of the plot got changed to IRRIGATED 
Internally retries are the if sensor is not available


5. To get details of a plot by the name


GET                   http://localhost:8080/getByplotName?plotName=Apple

Response 

[
    {
        "plotName": "Apple",
        "timeSlot": 11,
        "waterAmount": 90000,
        "status": "IRRIGATED"
    }
]
