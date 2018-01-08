(ns w.core (:require [reagent.core :as r]
                     [goog.string :as gs] goog.string.format))

(defn spiral [r n p]
  (let [c (/ p (* 2 Math/PI)) s (/ (* 2 Math/PI r) n)]
    (for [i (range n) :let [a (* s i)]]
      (gs/format " %.2f,%.2f" (* c a (Math/cos a)) (* c a (Math/sin a))))))

(defn svg-spiral [w h n]
  [:svg {:width w :height h }
   [:path {:fill "transparent" :stroke "black"
           :d (apply str (gs/format "M %d,%d t" (/ w 2) (/ h 2))
                         (spiral (+ 500 n) 1000 3.3))}]])

(defn root []
  (let [n (r/atom -1000)]
    (fn [] (js/setTimeout #(swap! n inc) 2)
      [:div (svg-spiral 800 700 (/ @n 120))])))

(defn init! [] (r/render [root] (.getElementById js/document "app")))
