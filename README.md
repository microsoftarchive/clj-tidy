

# clj-tidy [![Build Status](https://travis-ci.org/wunderlist/clj-tidy.svg)](https://travis-ci.org/wunderlist/clj-tidy)

clj-tidy is a wrapper around [JTidy](http://jtidy.sourceforge.net/). Currently only validation (errors and warnings)
are supported. clj-tidy wraps the original InputSteam-based interface of JTidy with
strings for input and maps of the validation errors as output.


## Releases and Dependency Information

clj-tidy is released via [Clojars](https://clojars.org/clj-tidy). The Latest stable release is 0.0.1

[Leiningen](https://github.com/technomancy/leiningen) dependency information:

```clojure
[clj-tidy "0.0.1"]
```

Maven dependency information:

```xml
<dependency>
  <groupId>clj-tidy</groupId>
  <artifactId>clj-tidy</artifactId>
  <version>0.0.1</version>
</dependency>
```


## Example Usage

```clojure
(require '[clj-tidy.core :as tidy])

(tidy/warnings-and-errors "hmm")
; ({:line 1,
;   :column 1,
;   :type :warning,
;   :message "missing <!DOCTYPE> declaration",
;   :line-content "hmm"}
;  {:line 1,
;   :column 1,
;   :type :warning,
;   :message "plain text isn't allowed in <head> elements",
;   :line-content "hmm"}
;  {:line 1,
;   :column 4,
;   :type :warning,
;   :message "inserting missing 'title' element",
;   :line-content "hmm"})
```


## License

Copyright © 2015 6 Wunderkinder GmbH.

Distributed under the [MIT License](LICENSE).
