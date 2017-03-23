from sense_hat import SenseHat
import paho.mqtt.client as mqtt
import time

hostname = "iot.eclipse.org" # Sandbox broker
port = 1883 # Default port for unencrypted MQTT

topic1 = "krohak/temperature"
topic2 = "krohak/humidity"

sense=SenseHat()


# Initialize client instance
client = mqtt.Client()

# Bind events to functions
#client.on_connect = on_connect
#client.on_publish = on_publish

client.connect(hostname, port=port)

# start threaded interface to the network loop
client.loop_start()

while True:

	try:
		temperature=sense.get_temperature()
		humidity=sense.get_humidity()
		print("%.2f"%temperature)
		print("%.2f"%humidity)

		client.publish(topic1, payload="%.2f"%temperature, qos=0, retain=False)
		client.publish(topic2, payload="%.2f"%humidity, qos=0, retain=False)

	except Exception as e:
		print ("Run-time error: %s"%e)

	time.sleep(5)


# Network loop runs in the background to listen to the events
#time.sleep(5)
