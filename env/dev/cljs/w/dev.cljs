(ns ^:figwheel-no-load w.dev
  (:require
    [w.core :as core]
    [devtools.core :as devtools]))


(enable-console-print!)

(devtools/install!)

(core/init!)
