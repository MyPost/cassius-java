(ns cassius-java.core
  (:gen-class)
  (:use cassius.core))

(gen-class
  :name au.com.auspost.Cassius
  :state state
  :init init
  :prefix "-"
  :main false
  :constructors {[String Long java.util.Map] []}
  :methods [[putIn   [java.util.ArrayList Object] Void]
            [dropIn  [java.util.ArrayList] Void]
            [keysIn  [java.util.ArrayList] java.util.List]
            [peekIn  [java.util.ArrayList] Object]
            [setIn   [java.util.ArrayList Object] Void]
            [mutateIn   [java.lang.String java.util.Map java.util.ArrayList] Void]
            [streamIn   [java.util.ArrayList Object] java.util.List]
            [schema  [] java.util.Map]
            [initSchema  [java.util.Map] Void]
            [backup  [Object] Void]
            [restore [Object] Void]
            [patch   [java.util.Map] Void]
          ^{:static true} [diff [java.util.Map java.util.Map] java.util.Map]])

(defn -init
  [host port opts]
  [[] (let [conn (connect host port opts)]
        conn)])

(defn -putIn [this sel val]
  (put-in (.state this) sel val)
  nil)

(defn -dropIn [this sel]
  (drop-in (.state this) sel)
  nil)

(defn -keysIn [this sel]
  (java.util.ArrayList. (keys-in (.state this) sel)))

(defn -peekIn [this sel]
  (peek-in (.state this) sel))

(defn -setIn [this sel val]
  (set-in (.state this) sel val))

(defn -streamIn [this sel val]
  (stream-in (.state this) sel val))

(defn -mutateIn [this ks add-map del-vec]
  (mutate-in (.state this) ks add-map del-vec)
  nil)

(defn -initSchema [this schema]
  (init-schema (.state this) schema)
  nil)

(defn -schema [this]
  (schema (.state this) :outline))

(defn -backup [this source]
  (backup (.state this) source)
  nil)

(defn -restore [this source]
  (restore (.state this) source)
  nil)

(defn -patch [this changes]
  (patch (.state this) changes)
  nil)

(defn -diff [old new]
  (diff old new))
