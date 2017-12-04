(ns day2-corruption-checksum.core)

(defn checksum [& rows]
  (apply + (map #(- (apply max %) (apply min %)) rows)))

