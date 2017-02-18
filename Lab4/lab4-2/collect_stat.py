import subprocess

#f = open('percent_matrixdriver_linked.txt', 'w')
#sizes = [100,500,1000,2000,5000]
sizes = [5000]

command = '/usr/bin/java SparseMatrixDriver '
for i in sizes:
	for j in range(5,100,5):
		p = command + str(i) + " " + str(j)+ " >> " + str(i) + "rpi_percent_matrixdriver_linked.txt"
		subprocess.call(p, shell=True)
		print(p)
