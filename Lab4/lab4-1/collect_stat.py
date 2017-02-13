import subprocess

f = open('data_quicksort.txt', 'w')
sizes = []
for i in range(5, 20):
	sizes.append(i * 1000000)

command = '/usr/bin/java TimeQuickSort '
for i in sizes:
	p = command + str(i) + " >> data_quicksort.txt"
	subprocess.call(p, shell=True)
