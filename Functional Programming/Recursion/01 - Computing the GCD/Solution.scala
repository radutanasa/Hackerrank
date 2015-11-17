object Solution extends App {

	def gcd(x: Int, y: Int): Int =
		if (x == y) x
		else if (x < y) gcd(y, x)
		else gcd(x - y, y)

	println(gcd(10, 5))
}
