(ns twelve-days-of-clojure.song
  (:refer-clojure :exclude [count first second]))

(defn true-love [c]
  (fn [gs]
    (concat (butlast gs)
            (list (str (last gs) c)))))

(def pear-tree (true-love \.))

(def count (true-love \,))

(defn partridge [gs]
  (if (seq (next gs))
    (cons 'and (last gs))
    (last gs)))

(def gifts (atom ()))

(defn keep-counting [gift]
  (let [gs (swap! gifts conj gift)]
    (run! #(apply println %) (map count (butlast gs)))
    (apply println (pear-tree (partridge gs)))))

(defn wrap-gift [x]
  (list 'quote x))

(defn sing [& lines]
  (run! #(apply println %) (butlast lines))
  (keep-counting (last lines))
  (newline))

(defmacro On [& verse]
  (->> &form
       (partition-all 6)
       (map wrap-gift)
       (list* `sing)))

(On the first day of Christmas
    my true love sent to me
    a partridge in a pear tree)

(On the second day of Christmas
    my true love sent to me
    Two turtle doves)

(On the third day of Christmas
    my true love sent to me
    Three French hens)

(On the fourth day of Christmas
    my true love sent to me
    Four calling birds)

(On the fifth day of Christmas
    my true love sent to me
    Five golden rings)

(On the sixth day of Christmas
    my true love sent to me
    Six geese a-laying)

(On the seventh day of Christmas
    my true love sent to me
    Seven swans a-swimming)

(On the eighth day of Christmas
    my true love sent to me
    Eight maids a-milking)

(On the ninth day of Christmas
    my true love sent to me
    Nine ladies dancing)

(On the tenth day of Christmas
    my true love sent to me
    Ten lords a-leaping)

(On the eleventh day of Christmas
    my true love sent to me
    Eleven pipers piping)

(On the twelfth day of Christmas
    my true love sent to me
    Twelve drummers drumming)
