(ns clj-tidy.core-test
  (:require [midje.sweet :refer :all]
            [clj-tidy.core :as core]))

(facts "about warnings-and-errors"
  (core/warnings-and-errors "")
  => [{:line 1,
       :column 1,
       :line-content "",
       :type :warning,
       :message "inserting missing 'title' element"}])
