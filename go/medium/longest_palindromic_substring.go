package medium

func longestPalindrome(s string) string {
	if s == "" || len(s) < 2 {
		return s
	}
	longestStr := ""
	for i := 0; i < len(s); i++ {
		a := findPalindrome(s, i, i)
		if len(longestStr) < len(a) {
			longestStr = a
		}
		b := findPalindrome(s, i, i+1)
		if len(longestStr) < len(b) {
			longestStr = b
		}
	}

	return longestStr
}

func findPalindrome(s string, i, j int) string {
	for i >= 0 && j < len(s) && s[i] == s[j] {
		i--
		j++
	}
	return s[i+1 : j]
}
