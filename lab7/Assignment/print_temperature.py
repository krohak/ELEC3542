import time
from sense_hat import SenseHat

sense = SenseHat()

temperature=sense.get_temperature()

print(temperature)

sense.show_message(str(temperature))
