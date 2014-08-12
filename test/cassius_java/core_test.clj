(ns cassius-java.core-test
  (:use midje.sweet)
  (:require [cassius-java.core :refer :all])
  (:import au.com.auspost.Cassius))

(def settings nil #_(read-string (slurp "settings.edn")))
(def host (or (:host settings) "localhost"))
(def port (or (:port settings) 9160))
(def cassius (Cassius. host port {:value-type :utf-8}))

(defn arr
  ([] (java.util.ArrayList.))
  ([& args]
   (java.util.ArrayList. args)))

(fact "clear the database"
  (.dropIn cassius (arr))
  (.peekIn cassius (arr))
   => {})

(fact "putting data into database"
  (.putIn cassius  (arr "app") {"user" {"1" {"age"  "10"}}})
  (.peekIn cassius (arr "app" "user"))
  => {"1" {"age" "10"}}

  (.putIn cassius (arr) {"app" {"user" {"1" {"name"  "Andy"}}}})
  (.peekIn cassius (arr "app" "user"))
  => {"1" {"age" "10" "name"  "Andy"}})
