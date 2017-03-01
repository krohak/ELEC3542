import time
from sense_hat import SenseHat

sense = SenseHat()
sense.clear((255,0,0))
time.sleep(1)
sense.clear((0,255,0))
time.sleep(1)
sense.clear((0,0,255))
time.sleep(1)
sense.show_message("Hello")
