import subprocess

f = open('data.txt', 'w')
sizes = []
for i in range(5, 20):
	sizes.append(i * 1000000)

command = '/usr/bin/java TimeSpaceMergeSort '
for i in sizes:
	p = command + str(i) + " >> data.txt"
	subprocess.call(p, shell=True)
