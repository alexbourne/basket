RBC Basket coding test by Alex Bourne

As time was short, I went for a simple implementation of the basket that uses a linked list guarded by a read/write lock. Using my
basket interface an alternative implementation could have been a hash of items with their counts, and could therefore be 
chosen or switched at runtime. The implementation choice would come down to context and usage and the performance required, 
e.g. if there were a large number of unique items vs. a large quantity of each of a few items you may choose one over the 
other because of memory footprint, iteration time etc.

I have added a few tests for the basic functions of the basket. More features would of course require more/more complex tests.

Also I would add a more integration style test to test the concurrent read/write of the underlying collection in the basket. This
could be achieved using multiple threads and a barrier, plus a large basket - apologies, but I did not have time to code this over 
this particular weekend!

I may also have extended the Iterable interface as part of the Basket interface - this is a non trivial task as it would require
implementing a lot of methods guarded by the same read lock used to guard the collection. A decision to do this would depend on the
intended usage of the basket as it might not be necessary to expose the iterator at all(as with my getTotalCost() method).
