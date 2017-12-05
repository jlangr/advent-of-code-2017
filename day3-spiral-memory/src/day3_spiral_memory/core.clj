(ns day3-spiral-memory.core)

(defn sq [n] (* n n))

(defn int-sqrt [n]
  (int (Math/sqrt n)))

(defn is-exact-square-of-odd-number [n]
  (and
    (odd? (int (Math/floor (Math/sqrt n))))
    (= n (sq ( int (Math/sqrt n))))))

(defn ring-max [n]
  (if (is-exact-square-of-odd-number n)
    n
    (sq (+ (int-sqrt n) (if (odd? (int-sqrt n)) 2 1)))))

(defn ring [n]
  (quot (+ (int (Math/ceil (Math/sqrt n)))) 2))

(defn square-size [n]
  (int-sqrt (ring-max n)))

(defn less-than-ring-max [number]
  (- (ring-max number) number))

;; This is a very rote solution, seems disappointing.
;; I'm missing some simpler mathematical formula to
;; calculate things.
(defn x [n] (let [side-delta (dec (square-size n))]
    (cond
      (<= (less-than-ring-max n) (* 1 side-delta))
      (let [zero-index (- (ring-max n) side-delta)]
            (- n zero-index))

      (<= (less-than-ring-max n) (* 2 side-delta))
      0

      (<= (less-than-ring-max n) (* 3 side-delta))
      (+ side-delta (- (less-than-ring-max n) (* 3 side-delta)))

      :else
      side-delta)))

(defn y [n] (let [side-delta (dec (square-size n))]
    (cond
      (<= (less-than-ring-max n) (* 1 side-delta))
      side-delta

      (<= (less-than-ring-max n) (* 2 side-delta))
      (let [zero-index (- (ring-max n) (* 2 side-delta))]
            (- n zero-index))

      (<= (less-than-ring-max n) (* 3 side-delta))
      0

      :else
      (+ side-delta (- (less-than-ring-max n) (* 4 side-delta)))
      )))

(defn distance [number]
  (if (= number 1)
    0
    (let [x1 (x number)
          y1 (y number)
          x0 (quot (square-size number) 2)
          y0 x0]
      (+ (Math/abs (- x1 x0)) (Math/abs (- y1 y0))))))
