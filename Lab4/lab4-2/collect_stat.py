import subprocess

f = open('matrixdriver_2D.txt', 'w')
sizes = [100,500,1000,2000,5000]

command = '/usr/bin/java SparseMatrixDriver '
for i in sizes:
	p = command + str(i) + " 10 >> matrixdriver_2D.txt"
	subprocess.call(p, shell=True)
