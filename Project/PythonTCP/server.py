import socket
import sys

mysock=socket.socket(socket.AF_INET,socket.SOCK_STREAM)

try:	
	sk=('192.168.1.1',1234);
	mysock.bind(sk)
except socket.error:
	print("failed")
	sys.exit(1)

mysock.listen(5)
while True:
	conn,addr=mysock.accept()
	data=conn.recv(1000)
	if not data:
		break
	conn.sendall(data)
	print(addr[0]+","+ str(data))

conn.close()
mysock.close()
