#!/usr/bin/python3


'''
BONUS QUESTION

Changes needed to mitigate the drawbacks as suggested in Lab6.1:

1. Remove the infinite loop and sleep(3000) from the original Python code

2. Schedule this Python code to run with the Cron task scheduler:
 	- type the command
		`crontab -e`
   	- add the following line in crontab:
		*/5 * * * * python /path/to/file/sense_hat_thingspeak_http_bonus.py*

	This will make the Python code run every 5 minutes and log the data into the file.
'''

'''
Public Channel:
https://thingspeak.com/channels/233346
'''
from sense_hat import SenseHat
import time
import datetime
import requests

api_key = ''


def log_temperature_to_file(temperature,humidity,pressure,ID,timestring):
	temp_log =open("sense_hat_thingspeak_http.txt", "a")
	temp_log.write(timestring)
    	temp_log.write(" ID: " + ID)
	temp_log.write(" / T: %.2f" % temperature)
    	temp_log.write(" / H: %.2f" % humidity)
    	temp_log.write(" / P: %.2f\n" % pressure)
	temp_log.close()


sense=SenseHat()

try:
	temperature=sense.get_temperature()
    humidity=sense.get_humidity()
    pressure=sense.get_pressure()


	data = { "api_key": api_key, "field1": temperature, "field2": humidity, "field3": pressure }

    req = requests.post("https://api.thingspeak.com/update", data=data)
    ID=req.text
    if ID=="0":
    	ID="FAILED"



	timestring="["+ str(datetime.datetime.now())+"]"

	log_temperature_to_file(temperature,humidity,pressure,ID,timestring)

except Exception as e:
	print 'Run-time error:', e
