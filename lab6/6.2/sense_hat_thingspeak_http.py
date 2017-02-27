#!/usr/bin/python3
from sense_hat import SenseHat
import time
import datetime
import requests

api_key = ''
#https://thingspeak.com/channels/233346

def log_temperature_to_file(temperature,humidity,pressure,ID,timestring):
	temp_log =open("sense_hat_thingspeak_http.txt", "a")
	temp_log.write(timestring)
    	temp_log.write(" ID: " + ID)
	temp_log.write(" / T: %.2f" % temperature)
    	temp_log.write(" / H: %.2f" % humidity)
    	temp_log.write(" / P: %.2f\n" % pressure)
	temp_log.close()

sense=SenseHat()

while(1):
	temperature=sense.get_temperature()
    	humidity=sense.get_humidity()
    	pressure=sense.get_pressure()


    	data = { "api_key": api_key, "field1": temperature, "field2": humidity, "field3": pressure }

    	req = requests.post("https://api.thingspeak.com/update", data=data)
    	ID=req.text
    	if ID=="0":
        	ID="FAILED"
    	#print(req.status_code)
    	#print(req.json())


	timestring="["+ str(datetime.datetime.now())+"]"

	log_temperature_to_file(temperature,humidity,pressure,ID,timestring)

	time.sleep(300)
