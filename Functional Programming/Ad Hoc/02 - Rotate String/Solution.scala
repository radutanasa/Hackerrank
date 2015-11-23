object Solution extends App {

	val n = scala.io.StdIn.readInt()
	val lines = read(n)
	lines.foreach { line =>
		println(rotate(line).mkString(" "))
	}

	def read(n: Int): List[String] =
		if (n > 0) scala.io.StdIn.readLine() :: read(n - 1)
		else List()

	def rotate(s: String): List[String] = {
		def r(idx: Int): List[String] =
			if (idx < s.size) (s.substring(idx, s.size) + s.substring(0, idx)) :: r(idx + 1)
			else List(s)

		r(1)
	}

}
