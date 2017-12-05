(ns day3-spiral-memory.core)

(defn sq [n] (* n n))

(defn int-sqrt [n]
  (int (Math/sqrt n)))

(defn is-exact-square-of-odd-number [n]
  (and
    (odd? (int-sqrt n))
    (= n (sq (int-sqrt n)))))

(defn ring-max [n]
  (if (is-exact-square-of-odd-number n)
    n
    (sq (+ (int-sqrt n) (if (odd? (int-sqrt n)) 2 1)))))

(defn ring [n]
  (quot (+ (int (Math/ceil (Math/sqrt n)))) 2))

(defn square-size [n]
  (int-sqrt (ring-max n)))

(defn delta-max [number]
  (- (ring-max number) number))

;; This is a very rote solution, seems disappointing.
;; I'm missing some simpler mathematical formula to
;; calculate things.
(defn x [n] (let [side-delta (dec (square-size n))]
    (cond
      (<= (delta-max n) (* 1 side-delta))
      (- n (- (ring-max n) side-delta))

      (<= (delta-max n) (* 2 side-delta))
      0

      (<= (delta-max n) (* 3 side-delta))
      (+ side-delta (- (delta-max n) (* 3 side-delta)))

      :else
      side-delta)))

(defn y [n] (let [side-delta (dec (square-size n))]
    (cond
      (<= (delta-max n) (* 1 side-delta))
      side-delta

      (<= (delta-max n) (* 2 side-delta))
      (- n (- (ring-max n) (* 2 side-delta)))

      (<= (delta-max n) (* 3 side-delta))
      0

      :else
      (+ side-delta (- (delta-max n) (* 4 side-delta))))))

(defn distance [number]
  (let [center (quot (square-size number) 2)]
    (+ (Math/abs (- (x number) center)) (Math/abs (- (y number) center)))))
