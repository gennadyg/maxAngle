Alghorithm is to find maximum angle with object by using sliding window. if angle between current element and sliding window start ( rangeStartTreeIndex ) more than alpha, remove elements from the start of sliding window. Otherwize keep adding more alements.
In order to deal with 'overlapping' values in circle of points - { 350, 351, 5, 10 }, added a virtual points with angle + 360 value, so instead of array above, will be a following sorted array - { 350, 351, 365, 370, 5, 10 }.

Complexity:

Sorting: O(2nlg2n ) = O( nlgn ) 
Sliding window: O(2n) = O(n)

P.S. I think I have not resolved bug about presision of double during edge cases


