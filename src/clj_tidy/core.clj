(ns clj-tidy.core
  (:import (java.io StringWriter PrintWriter)
           (org.w3c.tidy Tidy)))

(defn- get-line-by-num
  [text line-number]
  (get (.split text "\n") (dec line-number)))

(defn warnings-and-errors
  "(InputStream | String) => seq of validation error maps"
  [html]
  (let [input-stream (if (string? html)
                        (clojure.java.io/input-stream (.getBytes html))
                        html)
        tidy (Tidy.)
        output (StringWriter.)
        printer (PrintWriter. output)]
    (doto tidy
      (.setErrout printer)
      (.setOnlyErrors true)
      (.parse input-stream output))
    (.flush printer)
    (.flush output)
    (for [line (.split (.toString output) "\n")
          :let [match (re-seq #"^line (\d+) column (\d+) - (\w+): (.+)$" line)]
          :when match
          :let [[[_ line col type msg]] match
                line-int (Integer/parseInt line)
                column-int (Integer/parseInt col)
                line-content (if (string? html)
                                (get-line-by-num html line-int)
                                nil)]]
      {:line line-int
       :column column-int
       :type (-> type .toLowerCase keyword)
       :message msg
       :line-content line-content})))
