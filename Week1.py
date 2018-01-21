class Test(object):
	"""docstring for Test"""
	def __init__(self, name):
		self.name = name
	def __str__(self):
		return "I'm "+str(self.name)
		

if __name__ == '__main__':
	test_av_class = Test("test_av_class")
	print test_av_class