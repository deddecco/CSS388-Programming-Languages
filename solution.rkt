(define average
  (lambda (list)
    (cond
      ;; if the list is too short, return false
      ((null? list) #f) 
      ((null? (cdr list)) #f) 
      ((null? (cddr list)) #f) 

      ;; check if position 1 is the average of positions 2 and 3
      ((= (car list) (/ (+ (cadr list) (caddr list)) 2)) #t)
      ;; check if position 2 is the average of positions 1 and 3
      ((= (cadr list) (/ (+ (car list) (caddr list)) 2)) #t)
      ;; check if position 3 is the average of positions 1 and 2
      ((= (caddr list) (/ (+ (car list) (cadr list)) 2)) #t)
      ;; if you found a match in the first 3 elements, return #t

      ((null? (cdddr list)) #f) ;; does the list have 3 or not-- if it does, then all 3 have been checked
      ;; and if this has been reached, no match has been found, so false should be returned

      ;; if any of the following are true, a match has been found:
      ;; Recursively skip the first element and check the rest
      ((average (cdr list)) #t)
      ;; Recursively skip the second element and check the rest
      ((average (cons (car list) (cddr list))) #t)
      ;; Recursively skip the third element and check the rest
      (else  (average (cons (car list) (cons (cadr list) (cdddr list))))
             ))))