object Solution extends App {

	def f(x: Float): Float = {
		def factorial(n: Int): Int =
			if (n == 0) 1
			else n * factorial(n - 1)

		def approxE(x: Float, n: Int): Float = {
			if (n == 0) 1
			else (Math.pow(x.toDouble, n)/factorial(n)).toFloat + approxE(x, n - 1)
		}
		// 10 factors
		approxE(x, 9)
	}

	println(f(20))
}
