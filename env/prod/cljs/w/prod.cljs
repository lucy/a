(ns w.prod (:require [w.core :as core]))
(set! *print-fn* (fn [& _])) ;ignore println statements in prod
(core/init!)
