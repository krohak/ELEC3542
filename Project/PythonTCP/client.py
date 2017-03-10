import socket
import sys

mysock=socket.socket(socket.AF_INET,socket.SOCK_STREAM)

try:	
	ainfo=socket.getaddrinfo("192.168.1.2",1234)
	mysock.connect(ainfo[0][4])

	mysock.sendall("data")
	

except socket.error:
	print("failed")
	sys.exit(1)



mysock.close()
