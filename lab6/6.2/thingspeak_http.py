import requests

api_key = ''
temperature = 65.5
humidity = 100.0
pressure = 913.0

data = { "api_key": api_key, "field1": temperature, "field2": humidity, "field3": pressure }

req = requests.post("https://api.thingspeak.com/update", data=data)
print(req.text)
print(req.status_code)
print(req.json())
