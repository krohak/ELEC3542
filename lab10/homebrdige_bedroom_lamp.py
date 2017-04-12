import tornado.ioloop
import tornado.web
from sense_hat import SenseHat

sense = SenseHat()

e = [0,0,0]

image = [
    [255, 0, 0], [255, 0, 0], [255, 87, 0], [255, 196, 0], [205, 255, 0], [95, 255, 0], [0, 255, 13], [0, 255, 122],
    [255, 0, 0], [255, 96, 0], [255, 205, 0], [196, 255, 0], [87, 255, 0], [0, 255, 22], [0, 255, 131], [0, 255, 240],
    [255, 105, 0], [255, 214, 0], [187, 255, 0], [78, 255, 0], [0, 255, 30], [0, 255, 140], [0, 255, 248], [0, 152, 255],
    [255, 223, 0], [178, 255, 0], [70, 255, 0], [0, 255, 40], [0, 255, 148], [0, 253, 255], [0, 144, 255], [0, 34, 255],
    [170, 255, 0], [61, 255, 0], [0, 255, 48], [0, 255, 157], [0, 243, 255], [0, 134, 255], [0, 26, 255], [83, 0, 255],
    [52, 255, 0], [0, 255, 57], [0, 255, 166], [0, 235, 255], [0, 126, 255], [0, 17, 255], [92, 0, 255], [201, 0, 255],
    [0, 255, 66], [0, 255, 174], [0, 226, 255], [0, 117, 255], [0, 8, 255], [100, 0, 255], [210, 0, 255], [255, 0, 192],
    [0, 255, 183], [0, 217, 255], [0, 109, 255], [0, 0, 255], [110, 0, 255], [218, 0, 255], [255, 0, 183], [255, 0, 74]
]

image2 = [
e,e,e,e,e,e,e,e,
    e,e,e,e,e,e,e,e,
e,e,e,e,e,e,e,e,
e,e,e,e,e,e,e,e,
e,e,e,e,e,e,e,e,
e,e,e,e,e,e,e,e,
e,e,e,e,e,e,e,e,
e,e,e,e,e,e,e,e
]

lamp = 0

def lamp_on():
	print("Lamp is turned ON")
	lamp = 1
	sense.set_pixels(image)

def lamp_off():
	print("Lamp is turned OFF")
	lamp = 0
	sense.set_pixels(image2)


def read_lamp():
	return str(lamp)

class LampHandler(tornado.web.RequestHandler):
	def get(self, action):
		if action == "/on":
			# /lamp/on
			lamp_on()
		elif action == "/off":
			# /lamp/off
			lamp_off()
		elif action == "":
			# /lamp
			self.write(read_lamp())

def make_app():
	return tornado.web.Application([
		(r"/lamp(.*)", LampHandler),
	])

if __name__ == "__main__":
	app = make_app()
	app.listen(80)
	tornado.ioloop.IOLoop.current().start()
