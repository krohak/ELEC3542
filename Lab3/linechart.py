#!/usr/bin/python3

import pygal
#http://pygal.org/en/stable/documentation/types/line.html

line_chart = pygal.Line()
line_chart.title = 'Versions of MergeSort'
line_chart.x_labels = map(str, range(6000000, 21000000, 1000000))
line_chart.add('TimeParralelMergeSort', [2796,3263,3832,4803,5537,6375,8862,10382,15885,28370])
line_chart.add('TimeMergeSort',  [4877,5900,6932,7829,8885,10057,11521,12857,14747,18895,22156,24554,34711,37866,66173])
line_chart.add('Client_TimeRemoteMergeSort',[50832,44578,55717,56533,61852,80177,78009,85243,114783,109130,106546,121036,124799,145586,137341,145291])
line_chart.render()

line_chart.render_to_file('line_chart.svg')
