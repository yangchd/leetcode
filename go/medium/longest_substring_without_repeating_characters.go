package medium

import "math"

func lengthOfLongestSubstring(s string) int {
	if s == "" || len(s) < 1 {
		return 0
	}
	l := 0.0
	left := 0
	right := 1
	for left <= right && right < len(s) {
		for i := left; i < right; i++ {
			if s[right] == s[i] {
				l = math.Max(l, float64(right-left))
				left = i + 1
				for left < right {
					if s[left] == s[right] {
						left++
					} else {
						break
					}
				}
				break
			}
		}
		right++
	}
	l = math.Max(l, float64(right-left))
	return int(l)
}
