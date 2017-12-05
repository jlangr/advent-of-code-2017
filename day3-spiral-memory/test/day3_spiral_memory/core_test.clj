(ns day3-spiral-memory.core-test
  (:require [clojure.test :refer :all]
            [day3-spiral-memory.core :refer :all]))

;; tests are based off this grid:

;; 37 36 35 34 33 32 31
;; 38 17 16 15 14 13 30
;; 39 18  5  4  3 12 29
;; 40 19  6  1  2 11 28
;; 41 20  7  8  9 10 27
;; 42 21 22 23 24 25 26
;; 43 44 45 46 47 48 49

(deftest ring-test
  (is (= 0 (ring 1)))
  (is (= 1 (ring 2)))
  (is (= 1 (ring 9)))
  (is (= 2 (ring 10)))
  (is (= 2 (ring 25)))
  (is (= 3 (ring 49)))
  (is (= 3 (ring 26)))
  (is (= 4 (ring 50))))

(deftest ring-max-test
  (is (= 9 (ring-max 5)))
  (is (= 25 (ring-max 19)))
  (is (= 25 (ring-max 10))))

(deftest y-test
  (is (= 6 (y 43)))
  (is (= 6 (y 45)))
  (is (= 6 (y 47)))
  (is (= 6 (y 49)))
  (is (= 0 (y 37)))
  (is (= 2 (y 39)))
  (is (= 5 (y 42)))
  (is (= 0 (y 36)))
  (is (= 0 (y 33)))
  (is (= 0 (y 31)))
  (is (= 1 (y 30)))
  (is (= 4 (y 27)))
  (is (= 5 (y 26))))

(deftest x-test
  (is (= 1 (x 8)))
  (is (= 6 (x 49)))
  (is (= 5 (x 48)))
  (is (= 4 (x 47)))
  (is (= 0 (x 43)))
  (is (= 0 (x 41)))
  (is (= 0 (x 37)))
  (is (= 1 (x 36)))
  (is (= 2 (x 35)))
  (is (= 3 (x 34)))
  (is (= 4 (x 33)))
  (is (= 5 (x 32)))
  (is (= 6 (x 31)))
  (is (= 6 (x 26)))
  (is (= 6 (x 28)))
  (is (= 6 (x 30))))

(deftest square-size-test
  (is (= 7 (square-size 45))))

(deftest cells-to-backtrack-from-test
  (is (= 0 (less-than-ring-max 49)))
  (is (= 13 (less-than-ring-max 36)))
  (is (= 2 (less-than-ring-max 47)))
  (is (= 2 (less-than-ring-max 7)))
  (is (= 3 (less-than-ring-max 6)))
  (is (= 4 (less-than-ring-max 5)))
  (is (= 5 (less-than-ring-max 4)))
  (is (= 6 (less-than-ring-max 3)))
  (is (= 7 (less-than-ring-max 2))))

(deftest manhattan-distance
  (is (= 0 (distance 1)))
  (is (= 2 (distance 23)))
  (is (= 3 (distance 12)))
  (is (= 5 (distance 32)))
  (is (= 6 (distance 31)))
  (is (= 6 (distance 49)))
  (is (= 31 (distance 1024)))
  (is (= 480 (distance 347991))))
