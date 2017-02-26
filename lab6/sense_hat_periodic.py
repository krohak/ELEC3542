#!/usr/bin/python3
from sense_hat import SenseHat
import time
import datetime

def log_temperature_to_file(temperature,temp):
	temp_log =open("temperature.txt", "a")
	temp_log.write(temp)
	temp_log.write(" Temperature:%.2f\n" % temperature)
	temp_log.close()

sense=SenseHat()

while(1):
	temperature=sense.get_temperature()
	temp="["+ str(datetime.datetime.now())+"]"

	#print("Temperature:", temperature)
	log_temperature_to_file(temperature,temp)
	

	time.sleep(10)
