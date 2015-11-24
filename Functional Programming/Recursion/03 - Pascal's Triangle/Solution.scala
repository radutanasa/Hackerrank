object Solution extends App {

	val n = scala.io.StdIn.readInt()

	def pascalsTriangle(n: Int) = {

		def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

		def row(k: Int, r: Int): Unit = {
			if (r <= k) {
				print((factorial(k) / (factorial(r) * factorial(k-r))) + " ")
				row(k, r + 1)
			}
		}

		(0 to n-1).foreach(k => {
			row(k, 0)
			println()
		})
	}

	pascalsTriangle(n)

}
