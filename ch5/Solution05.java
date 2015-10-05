/*********************************************************************************
*     File Name           :     Solution05.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-10-05 09:30]
*     Last Modified       :     [2015-10-05 09:34]
*     Description         :     Debugger 
*
*       `n-1` sets all low zeros to 1 and sets first 1 from low bits (left) to zero
*       `n & (n-1)` filter out the high bits from the first non-zero bit
*       `(n & (n-1)) == 0` checks if high bits are zero
*
*       the expression checks if the bits of the number has only one bit set to 1
*       (is a power of 2), or 0
**********************************************************************************/


