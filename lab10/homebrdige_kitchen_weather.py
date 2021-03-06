import tornado.ioloop
import tornado.web
from sense_hat import SenseHat

sense = SenseHat()


def read_weather():
	temp=sense.get_temperature()
	hum=sense.get_humidity()
	weather={ "temperature": temp,"humidity": hum }
	return(weather)

class WeatherHandler(tornado.web.RequestHandler):
	def get(self, action):
		if action == "":
			# /weather
			self.write(read_weather())

def make_app():
	return tornado.web.Application([
		(r"/weather(.*)", WeatherHandler),
	])

if __name__ == "__main__":
	app = make_app()
	app.listen(80)
	tornado.ioloop.IOLoop.current().start()
