package medium

func convert(s string, numRows int) string {
	if numRows <= 1 || len(s) <= 1 {
		return s
	}
	matrix := make([]string, numRows)

	down := 1
	n := 0
	for i := 0; i < len(s); i++ {
		matrix[n] = matrix[n] + string(s[i])
		if n == numRows-1 {
			down = -1
		} else if n == 0 {
			down = 1
		}
		n = n + down
	}
	res := ""
	for j := 0; j < numRows; j++ {
		res += matrix[j]
	}
	return res
}
