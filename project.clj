(defproject
 cheffy "0.1.0-SNAPSHOT"
 :description "Cheffy REST API"
 :url "https://api.learnreitit.com"
 :dependencies [[clj-http "3.10.0"]
                [com.github.seancorfield/next.jdbc "1.2.761"]
                [environ "1.2.0"]
                [integrant "0.8.0"]
                [metosin/reitit "0.5.5"]
                [org.clojure/clojure "1.10.1"]
                [org.postgresql/postgresql "42.3.1"]
                [ovotech/ring-jwt "1.3.0"]
                [ring "1.8.1"]]
 :profiles {:uberjar {:aot :all}
            :dev {:source-paths ["dev/src"]
                  :resource-paths ["dev/resources"]
                  :dependencies [[ring/ring-mock "0.4.0"]
                                 [integrant/repl "0.3.1"]]}}
 :uberjar-name "cheffy.jar")
