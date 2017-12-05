(ns day4-high-entropy-passphrases.core-test
  (:require [clojure.test :refer :all]
            [day4-high-entropy-passphrases.core :refer :all]))

(deftest duplication-validator
  (testing "is valid when empty"
    (is (valid? "")))
  (testing "is valid with single word"
    (is (valid? "x")))
  (testing "is invalid with two duplicate words"
    (is (not (valid? "x x"))))
  (testing "sample tests provided"
    (is (valid? "aa bb cc dd ee"))
    (is (not (valid? "aa bb cc dd aa")))
    (is (valid? "aa bb cc dd aaa"))))

(deftest anagram-validator
  (testing "is valid when empty"
    (is (a-valid? "")))
  (testing "is valid with single word"
    (is (a-valid? "x")))
  (testing "is invalid with two duplicate words"
    (is (not (a-valid? "x x"))))
  (testing "sample tests provided"
    (is (a-valid? "abcde fghij"))
    (is (a-valid? "a ab abc abd abf abj"))
    (is (a-valid? "iiii oiii ooii oooi oooo"))
    (is (not (a-valid? "abcde xyz ecdab")))
    (is (not (a-valid? "oiii ioii iioi iiio")))))


(deftest integration-test-duplicates
  (with-open [reader (clojure.java.io/reader "./input.txt")]
    (println "duplicate validator valid passphrases" (count (filter valid? (line-seq reader))))))

(deftest integration-test-anagrams
  (with-open [reader (clojure.java.io/reader "./input.txt")]
    (println "anagram validator valid passphrases" (count (filter a-valid? (line-seq reader))))))
