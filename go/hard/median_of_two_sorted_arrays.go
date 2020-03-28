package hard

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	max := len(nums1) + len(nums2)
	if max <= 0 {
		panic("all nums are empty")
	}

	left := 0
	right := 0
	last := 0
	for i := max / 2; i > 0; i-- {
		if left < len(nums1) && right < len(nums2) {
			if nums1[left] <= nums2[right] {
				last = nums1[left]
				left++
				continue
			} else {
				last = nums2[right]
				right++
				continue
			}
		}
		if left >= len(nums1) {
			last = nums2[right]
			right++
			continue
		}
		if right >= len(nums2) {
			last = nums1[left]
			left++
			continue
		}
	}

	sum := 0.0
	if max%2 == 1 {
		if left < len(nums1) && right < len(nums2) {
			if nums1[left] <= nums2[right] {
				sum += float64(nums1[left])
			} else {
				sum += float64(nums2[right])
			}
		} else {
			if left >= len(nums1) {
				sum += float64(nums2[right])
			}
			if right >= len(nums2) {
				sum += float64(nums1[left])
			}
		}
		return sum
	} else {
		if left < len(nums1) && right < len(nums2) {
			if nums1[left] <= nums2[right] {
				sum += float64(nums1[left])
			} else {
				sum += float64(nums2[right])
			}
		} else {
			if left >= len(nums1) {
				sum += float64(nums2[right])
			}
			if right >= len(nums2) {
				sum += float64(nums1[left])
			}
		}
		return (sum + float64(last)) / 2.0
	}
}
