(defproject ranking "0.0.1"
  :description "Ranking Avalon Game Arena jugadores Yu-Gi-Oh! TCG"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [joodo "0.11.0"]
                 [hyperion/hyperion-api "3.6.0"]
                 [hyperion/hyperion-postgres "3.6.0"]
                 ]

  :joodo-root-namespace ranking.root
  :min-lein-version "2.0.0"
  :profiles {:dev {:dependencies [[speclj "2.2.0"]]}}
  :test-paths ["spec/"]
  :java-source-paths ["src/"]
  :plugins [[speclj "2.2.0"]]
  )
