import paho.mqtt.publish as publish

hostname = "iot.eclipse.org" # Sandbox broker
port = 1883 # Default port for unencrypted MQTT

topic = "krohak/test" # '/' as delimiter for sub-topics

# API reference can be found at https://eclipse.org/paho/clients/python/docs/#id17
publish.single(topic, payload="Hello, krohak!", 
	qos=0,
	hostname=hostname,
	port=port)
