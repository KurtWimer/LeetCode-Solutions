class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var big : IntArray = nums1
        var small: IntArray = nums2
        if (big.size < small.size){ //ensures we binary search the smaller array for an accurate cut
            val temp = big
            big = small
            small = temp
        }

        //general use variables
        val totalSize = big.size + small.size
        val partitionSize = totalSize shr 1
        //binary search variables
        var left = 0
        var right = small.size-1
        //values on the dividing cut (smallLeft, smallRight, bigLeft, bigRight)
        var sl = 0
        var sr = 0
        var bl = 0
        var br = 0
        while (true){
            val midSmall = (left+right) shr 1
            val midBig = partitionSize-midSmall - 2

            //INT MAX/MIN handles edge case where no values are used from one of the arrays
            sl = if (midSmall >= 0) small[midSmall] else Integer.MIN_VALUE
            sr = if (midSmall + 1 < small.size) small[midSmall+1] else Integer.MAX_VALUE
            bl = if (midBig >= 0) big[midBig] else Integer.MIN_VALUE
            br = if (midBig + 1 < big.size) big[midBig+1] else Integer.MAX_VALUE
            if (sl > br){
                right = midSmall - 1
            }
            else if (bl > sr){
                left = midSmall + 1
            }
            else {
                break
            }
        }
       
        return if (totalSize % 2 == 0){ //even case
            (Math.max(sl, bl) + Math.min(sr, br).toDouble()) /2
        }
        else{ //odd case
            Math.min(sr, br).toDouble()
        }
    }
}