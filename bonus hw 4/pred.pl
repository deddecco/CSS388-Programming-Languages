% either we have a triple in the first 3, or we remove one of the first 3 and check again
average([A,B,C|T]) :- (A is (B+C)/2; B is (A+C)/2; C is (A+B)/2; average([A,C|T]); average([A,B|T]); average([B,C|T])).
