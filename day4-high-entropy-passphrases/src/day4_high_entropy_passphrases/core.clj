(ns day4-high-entropy-passphrases.core)

(defn valid? [passphrase]
  (let [words (clojure.string/split passphrase #" ")]
    (= (count (set words)) (count words))))

(defn sorted-chars [word]
  (apply str (sort word)))

(defn a-valid? [passphrase]
  (let [words (clojure.string/split passphrase #" ")]
    (= (count (set (map sorted-chars words))) (count words))))
