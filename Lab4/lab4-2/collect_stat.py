import subprocess

f = open('matrixdriver_linked.txt', 'w')
sizes = [100,500,1000,2000,5000]

command = '/usr/bin/java SparseMatrixDriver '
for i in sizes:
	p = command + str(i) + " 90 >> matrixdriver_linked.txt"
	subprocess.call(p, shell=True)
