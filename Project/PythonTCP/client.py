import socket
import sys
import datetime
from sense_hat import SenseHat

sense = SenseHat()

mysock=socket.socket(socket.AF_INET,socket.SOCK_STREAM)

try:
        ainfo=socket.getaddrinfo("192.168.1.2",1234)
        mysock.connect(ainfo[0][4])
        date=str(datetime.datetime.now())

        humidity = str(sense.get_humidity())
        temp = str(sense.get_temperature())
        pressure = str(sense.get_pressure())
        north = str(sense.get_compass())

        packet=str(date+','+temp+','+pressure+','+humidity+','+north).encode()
        mysock.sendall(packet)


except socket.error:
        print("failed")
        sys.exit(1)



mysock.close()

