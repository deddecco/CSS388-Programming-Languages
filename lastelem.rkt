(define last-elem(lambda (Lst)
                   (cond
                     ((null? Lst) Lst)
                     ((null? (cdr Lst))(car Lst))
                     (else (last-elem (cdr Lst))))))