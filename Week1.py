class Test(object):
	"""docstring for Test"""
	def __init__(self, name):
		self.name = name
	def __str__(self):
		return "I'm "+str(self.name)
		

if __name__ == '__main__':
	test_av_class = Test("test_av_class")
	print test_av_class


dict_test = {"Ordbok" : "Ordbok er et objekt som inneholder ord.","Alex" : "Gutt paa 22"}
dict_test[1] = "Jente paa 24"
dict_test[2] = "Jente paa 24"
dict_test[3] = "Jente paa 24"
dict_test[4] = "Jente paa 24"
dict_test[5] = "Jente paa 24"
dict_test[7] = "Jente paa 24"

print 

for key in sorted(dict_test.keys()):
	print key